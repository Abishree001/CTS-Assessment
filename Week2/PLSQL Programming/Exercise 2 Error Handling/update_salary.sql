CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id IN NUMBER,
    p_percent IN NUMBER
) IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_percent / 100)
    WHERE emp_id = p_emp_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Employee ID does not exist.');
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating salary: ' || SQLERRM);
END;
/
