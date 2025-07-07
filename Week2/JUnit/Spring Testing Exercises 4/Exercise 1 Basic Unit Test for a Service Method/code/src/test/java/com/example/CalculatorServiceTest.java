package com.example;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculator = new CalculatorService();

        int result = calculator.add(2, 3);

        assertEquals(5, result, "2 + 3 should equal 5");
    }
}
