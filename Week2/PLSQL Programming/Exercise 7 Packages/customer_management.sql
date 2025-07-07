-- ================================================
-- CustomerManagement Package - Clean Version
-- ================================================

-- 🔄 Drop existing package if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP PACKAGE CustomerManagement';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -4043 THEN
      RAISE;
    END IF;
END;
/

-- 🔄 Drop existing table if it exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE customers CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN
      RAISE;
    END IF;
END;
/

-- 🧱 Create customers table
CREATE TABLE customers (
  customer_id NUMBER PRIMARY KEY,
  name        VARCHAR2(100),
  balance     NUMBER
);
/

-- 📦 Package specification
CREATE OR REPLACE PACKAGE CustomerManagement IS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2);
  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

-- 📦 Package body
CREATE OR REPLACE PACKAGE BODY CustomerManagement IS

  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO customers (customer_id, name, balance)
    VALUES (p_id, p_name, p_balance);
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE customers
    SET name = p_name
    WHERE customer_id = p_id;
  END;

  FUNCTION GetBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT balance INTO v_balance
    FROM customers
    WHERE customer_id = p_id;
    RETURN v_balance;
  END;

END CustomerManagement;
/

-- ✅ Enable output (only required in SQL*Plus or SQLcl)
SET SERVEROUTPUT ON;

-- ✅ Test block
BEGIN
  CustomerManagement.AddCustomer(1, 'Abi', 10000);
  CustomerManagement.UpdateCustomer(1, 'Abi M');
  DBMS_OUTPUT.PUT_LINE('Balance: ' || CustomerManagement.GetBalance(1));
END;
/
