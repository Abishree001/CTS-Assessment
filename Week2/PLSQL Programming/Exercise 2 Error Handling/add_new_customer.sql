CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_cust_id      IN NUMBER,
    p_name         IN VARCHAR2,
    p_age          IN NUMBER,
    p_balance      IN NUMBER,
    p_is_vip       IN CHAR,
    p_interest     IN NUMBER
) IS
BEGIN
    INSERT INTO customers (customer_id, name, age, balance, is_vip, interest_rate)
    VALUES (p_cust_id, p_name, p_age, p_balance, p_is_vip, p_interest);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
END;
/
