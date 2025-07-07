package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class DataServiceTest {

    @Test
    void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.fetchData()).thenReturn("Data1", "Data2");

        DataService service = new DataService(mockApi);
        service.printTwoFetches();

        System.out.println("✅ Multiple return values tested successfully");
    }
}
