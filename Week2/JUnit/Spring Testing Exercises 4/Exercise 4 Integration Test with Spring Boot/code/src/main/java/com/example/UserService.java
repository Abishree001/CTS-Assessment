package com.example;

import java.sql.SQLException;

public class UserService {
    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public User createUser(String name) throws SQLException {
        User user = new User(name);
        dao.save(user);
        return user;
    }

    public User getUserByName(String name) throws SQLException {
        return dao.findByName(name);
    }
}
