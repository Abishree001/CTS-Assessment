package com.example;

public class UserController {

    private final UserService userService = new UserService();

    public User getUser(Long id) {
        return userService.getUserById(id);
    }
}
