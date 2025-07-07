-- Enable output
SET SERVEROUTPUT ON;

-- Call stored procedure to transfer funds
EXEC SafeTransferFunds(1, 2, 2000);

-- Call stored procedure to update salary
EXEC UpdateSalary(1, 10);

-- Call stored procedure to add customer
EXEC AddNewCustomer(3, 'Ramya', 28, 6000, 'N', 7.0);
