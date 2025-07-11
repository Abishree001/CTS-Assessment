package com.example.ormjpql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    private String code;
    private String name;

    // Getters and Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
