package com.example;

public class UserService {
    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String name) {
        // Business logic
        notificationService.sendNotification("Welcome " + name + "!");
    }
}
