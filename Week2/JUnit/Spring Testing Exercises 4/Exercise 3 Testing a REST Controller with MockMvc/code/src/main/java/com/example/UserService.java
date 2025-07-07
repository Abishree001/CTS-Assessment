package com.example;

public class UserService {

    public User getUserById(Long id) {
        // Mock data — in real scenario this would come from a database
        return new User(id, "Mock User");
    }
}
