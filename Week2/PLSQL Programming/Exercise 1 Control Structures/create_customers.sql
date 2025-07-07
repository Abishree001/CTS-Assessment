CREATE TABLE customers (
    customer_id     NUMBER PRIMARY KEY,
    name            VARCHAR2(100),
    age             NUMBER,
    balance         NUMBER(10,2),
    is_vip          CHAR(1),
    interest_rate   NUMBER(5,2)
);
