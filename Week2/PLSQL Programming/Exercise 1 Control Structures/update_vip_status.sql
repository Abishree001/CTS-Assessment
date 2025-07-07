BEGIN
    FOR cust IN (SELECT customer_id, balance FROM customers) LOOP
        IF cust.balance > 10000 THEN
            UPDATE customers
            SET is_vip = 'Y'
            WHERE customer_id = cust.customer_id;
        ELSE
            UPDATE customers
            SET is_vip = 'N'
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/
