package com.example.paymentservice;

import org.springframework.stereotype.Component;

@Component
public class ThirdPartyClient {

    public String callThirdParty() {
        try {
            // Simulate slow API call
            Thread.sleep(4000); // 4 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Third-party response";
    }
}
