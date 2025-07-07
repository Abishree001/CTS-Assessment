CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id   IN NUMBER,
    p_amount          IN NUMBER
) IS
    v_from_balance NUMBER;
BEGIN
    -- Lock the source account row
    SELECT balance INTO v_from_balance
    FROM accounts
    WHERE account_id = p_from_account_id
    FOR UPDATE;

    -- Check sufficient funds
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
    END IF;

    -- Deduct from source
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;

    -- Add to destination
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO error_log(error_message) VALUES(SQLERRM);
        RAISE;
END SafeTransferFunds;
/
