package com.example.ormlearnone;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.ormlearnone.model.Country;
import com.example.ormlearnone.repository.CountryRepository;

@SpringBootApplication
public class OrmlearnoneApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmlearnoneApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Countries containing 'ou':");
        List<Country> countriesWithOu = countryRepository.findByNameContainingIgnoreCase("ou");
        countriesWithOu.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));

        System.out.println("\nCountries containing 'ou' (sorted):");
        List<Country> countriesSorted = countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou");
        countriesSorted.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));

        System.out.println("\nCountries starting with 'Z':");
        List<Country> countriesZ = countryRepository.findByNameStartingWithIgnoreCase("Z");
        countriesZ.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
    }
}
