package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    @Test
    public void testCreateUser() {
        UserService mockService = mock(UserService.class);
        UserController controller = new UserController(mockService);

        User mockUser = new User("Abi");
        when(mockService.saveUser(mockUser)).thenReturn(mockUser);

        User result = controller.createUser(mockUser);
        assertEquals("Abi", result.getName());

        System.out.println("✅ POST test passed");
    }
}
