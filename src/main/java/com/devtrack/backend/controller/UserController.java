package com.devtrack.backend.controller;
import org.springframework.web.bind.annotation.*;

import com.devtrack.backend.entity.User;
import com.devtrack.backend.repository.UserRepository;

@RestController
@RequestMapping ("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
