package com.example.gatewayresiliencedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public String fallback() {
        return "Fallback response: Service is temporarily unavailable.";
    }
}
