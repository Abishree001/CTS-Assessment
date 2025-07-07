package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testArgumentMatching() {
        // Step 1: Create mock object
        LoggerService mockLogger = mock(LoggerService.class);

        // Step 2: Inject mock into UserService
        UserService userService = new UserService(mockLogger);

        // Step 3: Call method with specific arguments
        userService.createUser("Abi");

        // Step 4: Verify with argument matchers
        verify(mockLogger).log(eq("INFO"), startsWith("User"));

        System.out.println("✅ log() called with expected arguments");
    }
}
