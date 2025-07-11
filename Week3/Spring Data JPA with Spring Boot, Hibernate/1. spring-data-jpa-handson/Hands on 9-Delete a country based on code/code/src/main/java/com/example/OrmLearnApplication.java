package com.cognizant.spring_learn;

import com.cognizant.spring_learn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        CountryService service = context.getBean(CountryService.class);

        System.out.println("🚀 Deleting country with code = 'IN'");
        service.deleteCountry("IN");
        System.out.println("✅ Deleted successfully.");
    }
}
