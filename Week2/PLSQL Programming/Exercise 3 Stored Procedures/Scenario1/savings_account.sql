-- [savings_interest.sql]

-- DROP procedure safely if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP PROCEDURE ProcessMonthlyInterest';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -4043 THEN RAISE; END IF; -- ignore "procedure does not exist"
END;
/

-- DROP table safely if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE savings_accounts CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN RAISE; END IF; -- ignore "table does not exist"
END;
/

-- Create table
CREATE TABLE savings_accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);

-- Insert sample data
INSERT INTO savings_accounts VALUES (201, 'Abiiii', 10000);
INSERT INTO savings_accounts VALUES (202, 'Murugaaa', 15000);
COMMIT;

-- Create procedure
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE savings_accounts
  SET balance = balance + (balance * 0.01);
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Monthly interest applied successfully.');
END;
/

-- Execute procedure
BEGIN
  ProcessMonthlyInterest;
END;
/

-- Show results
SELECT * FROM savings_accounts;
