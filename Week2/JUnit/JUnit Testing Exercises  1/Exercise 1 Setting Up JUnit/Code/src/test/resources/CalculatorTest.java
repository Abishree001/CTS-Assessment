package demo;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testSubtraction() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.subtract(3, 2));
    }
}

