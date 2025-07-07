-- ============================================
-- FILE: bank_triggers.sql
-- PURPOSE: Create triggers for update logs, audits, and transaction rules
-- ============================================

-- ========================================================
-- SCENARIO 1: UpdateCustomerLastModified (AFTER UPDATE)
-- ========================================================

-- Drop trigger/table if exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TRIGGER UpdateCustomerLastModified';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -4080 THEN RAISE; END IF;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

-- Create Customers table
CREATE TABLE Customers (
  customer_id NUMBER PRIMARY KEY,
  name VARCHAR2(100),
  last_modified DATE
);

-- Insert test data
INSERT INTO Customers VALUES (1, 'Abi', SYSDATE);
COMMIT;

-- Create the trigger
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.last_modified := SYSDATE;
END;
/

-- Test: update customer
UPDATE Customers SET name = 'Abi M' WHERE customer_id = 1;
COMMIT;

-- Check result
SELECT * FROM Customers;

-- ========================================================
-- SCENARIO 2: LogTransaction (AFTER INSERT ON Transactions)
-- ========================================================

-- Drop existing triggers/tables
BEGIN
  EXECUTE IMMEDIATE 'DROP TRIGGER LogTransaction';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -4080 THEN RAISE; END IF;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE AuditLog CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Transactions CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

-- Create Transactions table
CREATE TABLE Transactions (
  trans_id NUMBER PRIMARY KEY,
  acc_no NUMBER,
  trans_type VARCHAR2(20),
  amount NUMBER,
  trans_date DATE
);

-- Create AuditLog table
CREATE TABLE AuditLog (
  log_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  trans_id NUMBER,
  log_message VARCHAR2(200),
  log_time DATE
);

-- Create the trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog(trans_id, log_message, log_time)
  VALUES (:NEW.trans_id, 
          'Transaction logged: ' || :NEW.trans_type || ' of ' || :NEW.amount, 
          SYSDATE);
END;
/

-- Test: Insert transaction
INSERT INTO Transactions VALUES (1001, 401, 'Deposit', 2000, SYSDATE);
COMMIT;

-- Check logs
SELECT * FROM AuditLog;

-- ========================================================
-- SCENARIO 3: CheckTransactionRules (BEFORE INSERT)
-- ========================================================

-- Drop trigger if exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TRIGGER CheckTransactionRules';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -4080 THEN RAISE; END IF;
END;
/

-- Recreate accounts table if needed
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

CREATE TABLE accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);

-- Insert sample accounts
INSERT INTO accounts VALUES (401, 'Koushika', 8000);
INSERT INTO accounts VALUES (402, 'Madhu', 3000);
COMMIT;

-- Create rule enforcement trigger
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  acc_balance NUMBER;
BEGIN
  -- Check current balance
  SELECT balance INTO acc_balance FROM accounts WHERE acc_no = :NEW.acc_no;

  IF :NEW.trans_type = 'Withdrawal' AND :NEW.amount > acc_balance THEN
    RAISE_APPLICATION_ERROR(-20001, 'Withdrawal exceeds available balance.');
  ELSIF :NEW.trans_type = 'Deposit' AND :NEW.amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
  END IF;
END;
/

-- Test: Valid withdrawal
INSERT INTO Transactions VALUES (1002, 401, 'Withdrawal', 1000, SYSDATE);

-- Test: Invalid withdrawal (exceeds balance)
-- INSERT INTO Transactions VALUES (1003, 401, 'Withdrawal', 100000, SYSDATE);

-- Test: Invalid deposit (negative)
-- INSERT INTO Transactions VALUES (1004, 402, 'Deposit', -100, SYSDATE);

-- View updated tables
SELECT * FROM Transactions;
SELECT * FROM AuditLog;
