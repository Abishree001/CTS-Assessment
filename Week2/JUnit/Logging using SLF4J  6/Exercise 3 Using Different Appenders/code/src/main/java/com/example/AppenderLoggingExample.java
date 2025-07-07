package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);

    public static void main(String[] args) {
        logger.debug("Debug log: Starting application...");
        logger.info("Info log: Application is running.");
        logger.warn("Warning log: Low memory warning.");
        logger.error("Error log: Unexpected crash occurred.");
    }
}
