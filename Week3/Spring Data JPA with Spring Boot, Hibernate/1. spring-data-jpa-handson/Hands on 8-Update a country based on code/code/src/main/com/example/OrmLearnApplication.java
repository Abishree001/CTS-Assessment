package com.cognizant.springlearneight;

import com.cognizant.springlearneight.service.CountryService;
import com.cognizant.springlearneight.service.exception.CountryNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testGetCountry();
        testAddCountry();
        testUpdateCountry();
    }

    private static void testGetCountry() {
        LOGGER.info("Start - testGetCountry");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.info("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End - testGetCountry");
    }

    private static void testAddCountry() {
        LOGGER.info("Start - testAddCountry");

        Country newCountry = new Country();
        newCountry.setCode("FR");
        newCountry.setName("France");

        countryService.addCountry(newCountry);

        try {
            Country savedCountry = countryService.findCountryByCode("FR");
            LOGGER.info("Saved Country: {}", savedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }

        LOGGER.info("End - testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start - testUpdateCountry");

        try {
            countryService.updateCountry("FR", "French Republic");
            Country updatedCountry = countryService.findCountryByCode("FR");
            LOGGER.info("Updated Country: {}", updatedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }

        LOGGER.info("End - testUpdateCountry");
    }
}
