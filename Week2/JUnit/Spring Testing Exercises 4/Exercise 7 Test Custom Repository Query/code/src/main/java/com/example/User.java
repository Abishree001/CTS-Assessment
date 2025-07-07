package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // avoid using reserved keyword "user"
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public User() {}
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
