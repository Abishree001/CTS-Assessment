package com.cognizant.spring.learn.spring_learn_6;


import java.util.List;

import com.cognizant.spring.learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearn6Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearn6Application.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearn6Application.class, args);
        displayCountries();
    }

    public static void displayCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        List<Country> countryList = context.getBean("countryList", List.class);
        LOGGER.debug("Country List: {}", countryList);
        LOGGER.info("END");
    }
}

