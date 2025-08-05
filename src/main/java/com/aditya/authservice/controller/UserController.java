package com.aditya.authservice.controller;

import com.aditya.authservice.dto.RegisterRequest;
import com.aditya.authservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService usersService;
    @PostMapping(value = "/signup", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> signupUser(@Valid @RequestBody RegisterRequest requestBody){
        usersService.createUserWithPassword(requestBody);
        return ResponseEntity.ok("User created successfully");
    }
}
