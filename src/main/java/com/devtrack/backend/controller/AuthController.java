package com.devtrack.backend.controller;
import org.springframework.web.bind.annotation.*;

import com.devtrack.backend.entity.User;
import com.devtrack.backend.repository.UserRepository;
@RestController
@RequestMapping ("/login")
public class AuthController{
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping 
    public void login(){
        
    }
}