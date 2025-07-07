package com.example;

import java.sql.SQLException;

public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public User createUser(String name) throws SQLException {
        return service.createUser(name);
    }

    public User getUser(String name) throws SQLException {
        return service.getUserByName(name);
    }
}
