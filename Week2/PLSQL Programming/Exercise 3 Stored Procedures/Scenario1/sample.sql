-- Drop the procedure if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP PROCEDURE ProcessMonthlyInterest';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -4043 THEN -- ignore "object does not exist" error
      RAISE;
    END IF;
END;
/

-- Drop the table if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE savings_accounts CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN -- ignore "table does not exist" error
      RAISE;
    END IF;
END;
/
