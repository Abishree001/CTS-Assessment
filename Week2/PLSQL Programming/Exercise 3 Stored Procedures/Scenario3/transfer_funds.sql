-- Drop procedure safely if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP PROCEDURE TransferFunds';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -4043 THEN RAISE; END IF;
END;
/

-- Drop accounts table safely if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE accounts CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

-- Create accounts table
CREATE TABLE accounts (
  acc_no NUMBER PRIMARY KEY,
  holder_name VARCHAR2(100),
  balance NUMBER
);

-- Insert sample data
INSERT INTO accounts VALUES (401, 'Abiii', 8000);
INSERT INTO accounts VALUES (402, 'Murugaaa', 3000);
COMMIT;

-- Create the stored procedure
CREATE OR REPLACE PROCEDURE TransferFunds(
  from_acc IN NUMBER,
  to_acc IN NUMBER,
  amount IN NUMBER
) IS
BEGIN
  -- Deduct from source account if balance is sufficient
  UPDATE accounts
  SET balance = balance - amount
  WHERE acc_no = from_acc AND balance >= amount;

  -- Check if the deduction actually happened
  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance or invalid source account.');
  END IF;

  -- Add to destination account
  UPDATE accounts
  SET balance = balance + amount
  WHERE acc_no = to_acc;

  -- Check if destination account exists
  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Invalid destination account.');
  END IF;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Transfer completed successfully.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

-- Execute the procedure: transfer 1000 from acc 401 to 402
BEGIN
  TransferFunds(401, 402, 1000);
END;
/

-- View updated account balances
SELECT * FROM accounts;
