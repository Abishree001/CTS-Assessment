package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @GetMapping
    public List<Country> getAllCountries() {
        return Arrays.asList(
            new Country("US", "United States"),
            new Country("IN", "India"),
            new Country("JP", "Japan")
        );
    }
}
