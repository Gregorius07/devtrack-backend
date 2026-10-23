package com.devtrack.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.devtrack.backend.entity.User;
import com.devtrack.backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    public User createUser(
            String name,
            String email,
            String passwordHash
    ) {
        User user = new User(
                name,
                email,
                passwordHash
        );

        return userRepository.save(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}