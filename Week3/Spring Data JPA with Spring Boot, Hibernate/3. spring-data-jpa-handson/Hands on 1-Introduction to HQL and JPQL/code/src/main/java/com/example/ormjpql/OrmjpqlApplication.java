package com.example.ormjpql;

import com.example.ormjpql.model.Country;
import com.example.ormjpql.repository.CountryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmjpqlApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(OrmjpqlApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) {

        System.out.println("📌 JPQL SELECT:");
        List<Country> list = entityManager
                .createQuery("SELECT c FROM Country c WHERE c.name LIKE '%United%'", Country.class)
                .getResultList();
        list.forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));

        System.out.println("\n📌 JPQL UPDATE:");
        int updated = entityManager
                .createQuery("UPDATE Country c SET c.name = 'Bharat' WHERE c.code = 'IN'")
                .executeUpdate();
        System.out.println("Updated rows: " + updated);

        System.out.println("\n📌 JPQL DELETE:");
        int deleted = entityManager
                .createQuery("DELETE FROM Country c WHERE c.code = 'UK'")
                .executeUpdate();
        System.out.println("Deleted rows: " + deleted);

        System.out.println("\n📌 HQL INSERT (Hibernate-specific):");
        int inserted = entityManager
                .createQuery("INSERT INTO Country (code, name) SELECT 'NZ', 'New Zealand' FROM Country c WHERE c.code = 'AU'")
                .executeUpdate();
        System.out.println("Inserted rows: " + inserted);

        System.out.println("\n📌 Final Country Table:");
        countryRepository.findAll().forEach(c -> System.out.println(c.getCode() + " - " + c.getName()));
    }
}
