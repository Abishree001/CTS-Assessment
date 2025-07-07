package com.example;

public class UserService {

    private final UserRepository userRepository;

    // Constructor injection (no Spring)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
