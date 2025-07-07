package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionThrowerTest {

    @Test
    public void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();

        // Check that IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });
    }

    @Test
    public void testThrowExceptionMessage() {
        ExceptionThrower thrower = new ExceptionThrower();

        // Capture exception and verify the message
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException();
        });

        assertEquals("This is an illegal argument exception", exception.getMessage());
    }
}
