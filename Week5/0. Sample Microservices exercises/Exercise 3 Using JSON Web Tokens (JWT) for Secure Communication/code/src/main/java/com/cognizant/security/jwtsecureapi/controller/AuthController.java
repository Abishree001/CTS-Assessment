package com.cognizant.security.jwtsecureapi.controller;

import com.cognizant.security.jwtsecureapi.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cognizant.security.jwtsecureapi.model.AuthRequest;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;

    // Manually injecting via constructor
    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> login(@RequestBody AuthRequest authRequest) {
        if ("admin".equals(authRequest.getUsername()) && "admin".equals(authRequest.getPassword())) {
            String token = jwtTokenProvider.createToken(authRequest.getUsername());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Invalid credentials"));
        }
    }
}
