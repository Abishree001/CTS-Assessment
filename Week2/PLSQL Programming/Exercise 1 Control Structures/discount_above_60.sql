BEGIN
    FOR cust IN (SELECT customer_id, age, interest_rate FROM customers) LOOP
        IF cust.age > 60 THEN
            UPDATE customers
            SET interest_rate = interest_rate - (interest_rate * 0.01)
            WHERE customer_id = cust.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/
