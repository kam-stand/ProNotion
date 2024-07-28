package com.spring.controller;

import java.sql.Ref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.UserDto;
import com.spring.dto.auth.LoginDto;
import com.spring.dto.auth.RegistrationDto;
import com.spring.enums.Role;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;
import com.spring.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;

    private UserRepository userRepository;

    private UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
            UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        try {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setRole(Role.USER);
            userRepository.save(user);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating user");
        }
    }

}
