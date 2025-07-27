package com.example.oauth2_login_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to OAuth2 Demo. Go to /user to login.";
    }
}
