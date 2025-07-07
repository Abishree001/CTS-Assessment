package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testMethodCallOrder() {
        // Step 1: Create mock
        ActionPerformer mockPerformer = mock(ActionPerformer.class);

        // Step 2: Use service
        MyService service = new MyService(mockPerformer);
        service.doWork();

        // Step 3: Verify call order
        InOrder inOrder = inOrder(mockPerformer);
        inOrder.verify(mockPerformer).start();
        inOrder.verify(mockPerformer).perform();
        inOrder.verify(mockPerformer).end();

        System.out.println("✅ Method call order verified successfully");
    }
}
