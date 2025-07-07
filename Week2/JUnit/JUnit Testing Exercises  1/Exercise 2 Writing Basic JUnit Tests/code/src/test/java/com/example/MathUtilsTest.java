package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {

    MathUtils utils = new MathUtils();

    @Test
    public void testMultiply() {
        assertEquals(20, utils.multiply(4, 5));
        assertEquals(0, utils.multiply(0, 5));
        assertEquals(-15, utils.multiply(-3, 5));
    }

    @Test
    public void testIsEven() {
        assertTrue(utils.isEven(2));
        assertFalse(utils.isEven(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        utils.divide(10, 0); // should throw an exception
    }

    @Test
    public void testDivide() {
        assertEquals(5, utils.divide(10, 2));
        assertEquals(2, utils.divide(5, 2)); // Integer division
    }
}
