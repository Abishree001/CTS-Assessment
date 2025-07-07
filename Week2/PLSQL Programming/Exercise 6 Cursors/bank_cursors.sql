-- ===============================================
-- FILE: bank_cursors.sql
-- PURPOSE: Cursor examples for monthly statements, fees, and interest updates
-- ===============================================

-- =======================================================
-- SCENARIO 1: GenerateMonthlyStatements – Cursor for Monthly Transactions
-- =======================================================

-- Drop and recreate Transactions table
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Transactions CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

CREATE TABLE Transactions (
  trans_id NUMBER PRIMARY KEY,
  acc_no NUMBER,
  trans_type VARCHAR2(20),
  amount NUMBER,
  trans_date DATE
);

-- Insert sample monthly transactions
INSERT INTO Transactions VALUES (2001, 401, 'Deposit', 3000, SYSDATE - 5);
INSERT INTO Transactions VALUES (2002, 402, 'Withdrawal', 1000, SYSDATE - 3);
INSERT INTO Transactions VALUES (2003, 401, 'Deposit', 1500, ADD_MONTHS(SYSDATE, -1));
COMMIT;

-- Cursor block for monthly statements
DECLARE
  CURSOR monthly_cursor IS
    SELECT acc_no, trans_type, amount, trans_date
    FROM Transactions
    WHERE TRUNC(trans_date, 'MM') = TRUNC(SYSDATE, 'MM');

  v_acc_no Transactions.acc_no%TYPE;
  v_type Transactions.trans_type%TYPE;
  v_amount Transactions.amount%TYPE;
  v_date Transactions.trans_date%TYPE;
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Monthly Statement ---');

  OPEN monthly_cursor;
  LOOP
    FETCH monthly_cursor INTO v_acc_no, v_type, v_amount, v_date;
    EXIT WHEN monthly_cursor%NOTFOUND;

    DBMS_OUTPUT.PUT_LINE('Account: ' || v_acc_no || ', Type: ' || v_type || ', Amount: ' || v_amount || ', Date: ' || TO_CHAR(v_date, 'DD-MON-YYYY'));
  END LOOP;
  CLOSE monthly_cursor;
END;
/

-- =======================================================
-- SCENARIO 2: ApplyAnnualFee – Cursor to Deduct Annual Fee
-- =======================================================

-- Drop and recreate accounts table
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

-- Cursor block for applying annual fee
DECLARE
  CURSOR fee_cursor IS
    SELECT acc_no, balance FROM accounts;

  v_acc_no accounts.acc_no%TYPE;
  v_balance accounts.balance%TYPE;
  annual_fee CONSTANT NUMBER := 500;
BEGIN
  OPEN fee_cursor;
  LOOP
    FETCH fee_cursor INTO v_acc_no, v_balance;
    EXIT WHEN fee_cursor%NOTFOUND;

    UPDATE accounts
    SET balance = balance - annual_fee
    WHERE acc_no = v_acc_no;

    DBMS_OUTPUT.PUT_LINE('Annual fee of ' || annual_fee || ' applied to Account ' || v_acc_no);
  END LOOP;
  CLOSE fee_cursor;
  COMMIT;
END;
/

-- View updated balances
SELECT * FROM accounts;

-- =======================================================
-- SCENARIO 3: UpdateLoanInterestRates – Cursor for Loans
-- =======================================================

-- Drop and recreate loans table
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE loans CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

CREATE TABLE loans (
  loan_id NUMBER PRIMARY KEY,
  customer_name VARCHAR2(100),
  interest_rate NUMBER
);

-- Insert sample loans
INSERT INTO loans VALUES (101, 'Siva', 6.5);
INSERT INTO loans VALUES (102, 'Arun', 7.0);
INSERT INTO loans VALUES (103, 'Meena', 8.5);
COMMIT;

-- Cursor block for updating interest rates
DECLARE
  CURSOR loan_cursor IS
    SELECT loan_id, interest_rate FROM loans;

  v_loan_id loans.loan_id%TYPE;
  v_rate loans.interest_rate%TYPE;
BEGIN
  OPEN loan_cursor;
  LOOP
    FETCH loan_cursor INTO v_loan_id, v_rate;
    EXIT WHEN loan_cursor%NOTFOUND;

    -- New policy: increase all rates by 0.5%
    UPDATE loans
    SET interest_rate = v_rate + 0.5
    WHERE loan_id = v_loan_id;

    DBMS_OUTPUT.PUT_LINE('Interest rate updated for Loan ' || v_loan_id || ' from ' || v_rate || '% to ' || (v_rate + 0.5) || '%');
  END LOOP;
  CLOSE loan_cursor;
  COMMIT;
END;
/

-- View updated loans
SELECT * FROM loans;
