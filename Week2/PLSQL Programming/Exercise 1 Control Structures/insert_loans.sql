INSERT INTO loans (loan_id, customer_id, due_date)
VALUES (101, 1, SYSDATE + 15);

INSERT INTO loans (loan_id, customer_id, due_date)
VALUES (102, 2, SYSDATE + 45);  -- not in range

INSERT INTO loans (loan_id, customer_id, due_date)
VALUES (103, 3, SYSDATE + 5);

COMMIT;
