package com.devtrack.backend.controller;
import org.springframework.web.bind.annotation.*;

import com.devtrack.backend.entity.User;
import com.devtrack.backend.repository.UserRepository;
import com.devtrack.backend.service.UserService;

@RestController
@RequestMapping ("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @PatchMapping ("/{id}") 
    public User updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest updateRequest ){
        return userService.update(id, updateRequest);
    }

    public record UpdateUserRequest(String name, String email, String password){}
}
