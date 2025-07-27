package com.example.billingservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @GetMapping("/pay")
    public String pay() {
        return "Hello from Billing Service!";
    }
}
