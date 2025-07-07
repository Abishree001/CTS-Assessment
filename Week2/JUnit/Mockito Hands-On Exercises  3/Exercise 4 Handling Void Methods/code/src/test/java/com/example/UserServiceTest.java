package com.example;

import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    void testRealSendNotification() {
        // Using real object (no mocking!)
        NotificationService realNotificationService = new NotificationService();

        // Inject real object into service
        UserService userService = new UserService(realNotificationService);

        // Call the method
        userService.registerUser("Abi");

        // Optional: Confirmation
        System.out.println("✅ Real sendNotification executed successfully");
    }
}
