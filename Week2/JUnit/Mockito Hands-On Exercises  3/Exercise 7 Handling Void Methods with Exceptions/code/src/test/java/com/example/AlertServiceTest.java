package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlertServiceTest {

    @Test
    void testSendThrowsException() {
        // Step 1: Create mock
        Notifier mockNotifier = mock(Notifier.class);

        // Step 2: Stub void method to throw exception
        doThrow(new RuntimeException("Send failed"))
            .when(mockNotifier).send("CRITICAL");

        // Step 3: Inject and test
        AlertService service = new AlertService(mockNotifier);

        // Assertion for exception
        Exception ex = assertThrows(RuntimeException.class, () -> {
            service.raiseAlert("CRITICAL");
        });

        assertEquals("Send failed", ex.getMessage());

        // Verify method was called
        verify(mockNotifier).send("CRITICAL");

        System.out.println("✅ Exception from void method handled and verified");
    }
}
