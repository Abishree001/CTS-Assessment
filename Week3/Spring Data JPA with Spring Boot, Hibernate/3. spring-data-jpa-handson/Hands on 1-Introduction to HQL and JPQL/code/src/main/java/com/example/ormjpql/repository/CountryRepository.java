package com.example.ormjpql.repository;

import com.example.ormjpql.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {}
