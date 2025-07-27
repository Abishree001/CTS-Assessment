package com.cognizant.security.jwtsecureapi;

import com.cognizant.security.jwtsecureapi.security.JwtConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class)
public class JwtSecureApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtSecureApiApplication.class, args);
    }
}
