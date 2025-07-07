CREATE TABLE accounts (
    account_id   NUMBER PRIMARY KEY,
    account_name VARCHAR2(100),
    balance      NUMBER(10,2)
);
INSERT INTO accounts (account_id, account_name, balance) VALUES (1, 'Abhi', 5000);
INSERT INTO accounts (account_id, account_name, balance) VALUES (2, 'Kavi', 3000);
COMMIT;
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    from_acc_id IN NUMBER,
    to_acc_id   IN NUMBER,
    amount      IN NUMBER
) IS
BEGIN
    DECLARE
        insufficient_funds EXCEPTION;
        sender_balance NUMBER;
    BEGIN
        SELECT balance INTO sender_balance FROM accounts WHERE account_id = from_acc_id;

        IF sender_balance < amount THEN
            RAISE insufficient_funds;
        END IF;

        UPDATE accounts
        SET balance = balance - amount
        WHERE account_id = from_acc_id;

        UPDATE accounts
        SET balance = balance + amount
        WHERE account_id = to_acc_id;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Transfer successful.');
    EXCEPTION
        WHEN insufficient_funds THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
    END;
END;
/
SET SERVEROUTPUT ON;

EXEC SafeTransferFunds(1, 2, 2000);
