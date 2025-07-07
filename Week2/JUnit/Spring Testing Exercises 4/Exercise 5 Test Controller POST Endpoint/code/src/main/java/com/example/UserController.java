package com.example;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User createUser(User user) {
        return userService.saveUser(user);
    }
}
