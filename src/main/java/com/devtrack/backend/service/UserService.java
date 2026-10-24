package com.devtrack.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.devtrack.backend.controller.UserController.UpdateUserRequest;
import com.devtrack.backend.entity.User;
import com.devtrack.backend.helper.PasswordHasher;
import com.devtrack.backend.repository.UserRepository;

import jakarta.transaction.Transactional;

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
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(
            String name,
            String email,
            String passwordHash) {
        User user = new User(
                name,
                email,
                passwordHash);

        return userRepository.save(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional 
    public User update(Long id, UpdateUserRequest userRequest) {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User tidak tersedia"));
        PasswordHasher hasher = new PasswordHasher();
        if(userRequest.name() != null && !userRequest.name().isBlank()){
            currentUser.setName(userRequest.name());
        }
        if(userRequest.email() != null && !userRequest.email().isBlank()){
            currentUser.setEmail(userRequest.email());
        }
        if(userRequest.password() != null && !userRequest.password().isBlank()){
            currentUser.setPasswordHash(hasher.hash(userRequest.password()));
        }

        return userRepository.save(currentUser); 
    }
}