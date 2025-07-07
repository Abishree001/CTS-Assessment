package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    // Setup method (runs before each test)
    @Before
    public void setUp() {
        account = new BankAccount(100);  // Arrange
        System.out.println("Setup complete.");
    }

    // Teardown method (runs after each test)
    @After
    public void tearDown() {
        account.closeAccount();  // simulate resource cleanup
        System.out.println("Teardown complete.");
    }

    @Test
    public void testDeposit() {
        // Act
        account.deposit(50);

        // Assert
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testWithdrawSuccess() {
        // Act
        boolean result = account.withdraw(40);

        // Assert
        assertTrue(result);
        assertEquals(60, account.getBalance());
    }

    @Test
    public void testWithdrawFailure() {
        // Act
        boolean result = account.withdraw(200);

        // Assert
        assertFalse(result);
        assertEquals(100, account.getBalance());
    }
}
