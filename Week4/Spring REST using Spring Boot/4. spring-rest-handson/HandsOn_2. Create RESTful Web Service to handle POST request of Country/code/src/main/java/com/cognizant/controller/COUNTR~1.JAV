package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    private List<Country> countryList = new ArrayList<>();

    @PostMapping
    public String addCountry(@RequestBody Country country) {
        LOGGER.info("Start - addCountry()");
        countryList.add(country);
        LOGGER.info("Country added: Code={}, Name={}", country.getCode(), country.getName());
        return "Country added";
    }

    @GetMapping
    public List<Country> getCountries() {
        return countryList;
    }
}
