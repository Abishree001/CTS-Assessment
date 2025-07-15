package com.cognizant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Map<String, String>> getCountries() {
        return List.of(
                Map.of("code", "US", "name", "United States"),
                Map.of("code", "IN", "name", "India"),
                Map.of("code", "JP", "name", "Japan")
        );
    }
}
