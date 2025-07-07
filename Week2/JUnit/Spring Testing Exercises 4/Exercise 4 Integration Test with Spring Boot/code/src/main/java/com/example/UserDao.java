package com.example;

import java.sql.*;

public class UserDao {
    private final Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (id IDENTITY, name VARCHAR(100))";
        conn.createStatement().execute(sql);
    }

    public void save(User user) throws SQLException {
        String sql = "INSERT INTO users (name) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.executeUpdate();
    }

    public User findByName(String name) throws SQLException {
        String sql = "SELECT id, name FROM users WHERE name = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new User(rs.getLong("id"), rs.getString("name"));
        }
        return null;
    }
}
