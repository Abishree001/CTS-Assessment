package com.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTests {

    @Test
    @Tag("fast")
    void testStringLength() {
        assertTrue("JUnit".length() > 0);
    }
}
