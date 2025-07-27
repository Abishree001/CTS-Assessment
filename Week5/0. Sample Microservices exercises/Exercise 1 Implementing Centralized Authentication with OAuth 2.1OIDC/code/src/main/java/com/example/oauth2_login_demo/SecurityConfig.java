package com.example.oauth2_login_demo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
          .authorizeHttpRequests(auth -> auth
            .requestMatchers("/user").authenticated()
            .anyRequest().permitAll()
          )
          .oauth2Login(); // Enables OAuth2 Login

        return http.build();
    }
}
