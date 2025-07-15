package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:employee.xml")
public class EmployeeXmlConfigApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeXmlConfigApiApplication.class, args);
    }
}
