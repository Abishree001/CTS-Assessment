package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    private static StringBuilder output = new StringBuilder();

    @Test
    @Order(1)
    void testInitialization() {
        output.append("1");
        System.out.println("Step 1: Initialization");
        assertEquals("1", output.toString());
    }

    @Test
    @Order(2)
    void testExecution() {
        output.append("2");
        System.out.println("Step 2: Execution");
        assertEquals("12", output.toString());
    }

    @Test
    @Order(3)
    void testCleanup() {
        output.append("3");
        System.out.println("Step 3: Cleanup");
        assertEquals("123", output.toString());
    }
}
