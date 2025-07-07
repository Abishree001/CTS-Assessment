package com.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTests {

    @Test
    @Tag("fast")
    void testAddition() {
        assertEquals(5, 2 + 3);
    }

    @Test
    @Tag("slow")
    void testMultiplication() {
        assertEquals(9, 3 * 3);
    }
}
