package com.example;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

public class UserIntegrationTest {
    static Connection conn;
    static UserController controller;

    @BeforeAll
    static void setup() throws Exception {
        conn = DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        UserDao dao = new UserDao(conn);
        dao.createTable();
        controller = new UserController(new UserService(dao));
    }

    @Test
    void testCreateAndFetchUser() throws Exception {
        controller.createUser("Abi");
        User user = controller.getUser("Abi");
        assertNotNull(user);
        assertEquals("Abi", user.getName());
        System.out.println("✅ Integration test passed");
    }

    @AfterAll
    static void cleanup() throws Exception {
        conn.close();
    }
}
