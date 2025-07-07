-- Safe drop of procedure if exists
BEGIN
  EXECUTE IMMEDIATE 'DROP PROCEDURE UpdateEmployeeBonus';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -4043 THEN RAISE; END IF;
END;
/

-- Safe drop of employees table if exists
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE employees CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN
    IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

-- Create employees table
CREATE TABLE employees (
  emp_id NUMBER PRIMARY KEY,
  emp_name VARCHAR2(100),
  department VARCHAR2(50),
  salary NUMBER
);

-- Insert sample data
INSERT INTO employees VALUES (301, 'Siva', 'IT', 50000);
INSERT INTO employees VALUES (302, 'Arun', 'HR', 40000);
INSERT INTO employees VALUES (303, 'Meena', 'IT', 55000);
COMMIT;

-- Create the procedure
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  dept_name IN VARCHAR2,
  bonus_percent IN NUMBER
) IS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * bonus_percent / 100)
  WHERE department = dept_name;

  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Bonus applied to ' || dept_name || ' department.');
END;
/

-- Execute the procedure
BEGIN
  UpdateEmployeeBonus('IT', 10);
END;
/

-- Show updated data
SELECT * FROM employees;
