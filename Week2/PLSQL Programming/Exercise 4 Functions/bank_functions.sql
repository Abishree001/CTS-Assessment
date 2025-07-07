-- ====================================================
-- FILE: bank_functions.sql
-- PURPOSE: Function definitions and test cases
-- ====================================================

-- ============================================
-- 1. CalculateAge: Return age in years from DOB
-- ============================================
BEGIN
  EXECUTE IMMEDIATE 'DROP FUNCTION CalculateAge';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -4043 THEN RAISE; END IF;
END;
/

CREATE OR REPLACE FUNCTION CalculateAge(dob DATE)
RETURN NUMBER IS
  age NUMBER;
BEGIN
  age := TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12);
  RETURN age;
END;
/

-- Test CalculateAge
BEGIN
  DBMS_OUTPUT.PUT_LINE('Age: ' || CalculateAge(TO_DATE('2000-01-01', 'YYYY-MM-DD')));
END;
/

-- ============================================
-- 2. CalculateMonthlyInstallment: EMI Calculator
-- ============================================
BEGIN
  EXECUTE IMMEDIATE 'DROP FUNCTION CalculateMonthlyInstallment';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -4043 THEN RAISE; END IF;
END;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  loan_amount NUMBER,
  annual_interest_rate NUMBER,
  years NUMBER
)
RETURN NUMBER IS
  r NUMBER; -- monthly rate
  n NUMBER; -- total months
  emi NUMBER;
BEGIN
  r := annual_interest_rate / 12 / 100;
  n := years * 12;

  IF r = 0 THEN
    emi := loan_amount / n;
  ELSE
    emi := loan_amount * r * POWER(1 + r, n) / (POWER(1 + r, n) - 1);
  END IF;

  RETURN ROUND(emi, 2);
END;
/

-- Test CalculateMonthlyInstallment
BEGIN
  DBMS_OUTPUT.PUT_LINE('Monthly EMI: ' || CalculateMonthlyInstallment(500000, 8, 5));
END;
/

-- ============================================
-- 3. HasSufficientBalance: Balance Check
-- ============================================

-- Assume accounts table exists, create sample if needed:
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

CREATE TABLE accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);

INSERT INTO accounts VALUES (401, 'Koushika', 8000);
INSERT INTO accounts VALUES (402, 'Madhu', 3000);
COMMIT;

-- Drop HasSufficientBalance if exists
BEGIN
  EXECUTE IMMEDIATE 'DROP FUNCTION HasSufficientBalance';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -4043 THEN RAISE; END IF;
END;
/

-- Create HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
  acc_id NUMBER,
  required_amount NUMBER
)
RETURN BOOLEAN IS
  current_balance NUMBER;
BEGIN
  SELECT balance INTO current_balance
  FROM accounts
  WHERE acc_no = acc_id;

  RETURN current_balance >= required_amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;
/

-- Test HasSufficientBalance
DECLARE
  result BOOLEAN;
BEGIN
  result := HasSufficientBalance(401, 5000);
  IF result THEN
    DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
  END IF;
END;
/
