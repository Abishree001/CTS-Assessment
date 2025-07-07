package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // Step 1: Mock REST client
        RestClient mockRestClient = mock(RestClient.class);

        // Step 2: Stub response
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Step 3: Inject and test
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        assertEquals("Fetched Mock Response", result);
        System.out.println("✅ Service fetched mock REST response successfully");
    }
}
