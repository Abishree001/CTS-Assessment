package com.example;

public class UserService {
    private LoggerService logger;

    public UserService(LoggerService logger) {
        this.logger = logger;
    }

    public void createUser(String name) {
        // Business logic...
        logger.log("INFO", "User " + name + " created");
    }
}
