package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // Step 1: Create a mock network client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // Step 2: Stub the connect() method
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // Step 3: Inject into service
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        // Step 4: Verify the result
        assertEquals("Connected to Mock Connection", result);
        System.out.println("✅ Network service connected with mock client successfully");
    }
}
