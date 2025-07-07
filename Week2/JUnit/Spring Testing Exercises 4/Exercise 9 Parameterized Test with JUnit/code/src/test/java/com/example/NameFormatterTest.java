package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class NameFormatterTest {

    @ParameterizedTest
    @CsvSource({
        "Dr., Alice, Dr. Alice",
        "Mr., Bob, Mr. Bob",
        "Ms., Clara, Ms. Clara",
        "Prof., Dave, Prof. Dave"
    })
    public void testFormat(String prefix, String name, String expected) {
        String result = NameFormatter.format(prefix, name);
        assertEquals(expected, result);
    }
}
