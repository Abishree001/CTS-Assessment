package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "AbiShree";
        int loginAttempts = 3;

        logger.info("User {} has logged in successfully.", username);
        logger.warn("User {} has attempted to login {} times unsuccessfully.", username, loginAttempts);

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An error occurred while dividing: {}", e.toString());
        }
    }
}
