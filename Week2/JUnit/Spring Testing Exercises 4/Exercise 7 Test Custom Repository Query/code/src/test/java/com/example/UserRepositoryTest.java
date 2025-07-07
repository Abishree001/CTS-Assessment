package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        userRepository.save(new User("Alice"));
        userRepository.save(new User("Bob"));

        List<User> result = userRepository.findByName("Alice");

        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());

        System.out.println("✅ Custom query test passed");
    }
}
