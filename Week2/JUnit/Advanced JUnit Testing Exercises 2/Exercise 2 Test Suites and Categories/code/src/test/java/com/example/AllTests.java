package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    MathTests.class,
    StringTests.class
})
public class AllTests {
    // Empty class – used as a suite holder
}
