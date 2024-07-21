package com.example.springboot.controller;

import com.example.springboot.dto.UserDTO;
import com.example.springboot.model.User;
import com.example.springboot.services.MyUserDetailService;
import com.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailService myUserDetailService;

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String username, String password) {
        try {
            var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            // Successful authentication
            // Session management (optional)
            SecurityContextHolder.getContext().setAuthentication(authentication); // Optional for session management

            return ResponseEntity.ok("Login successful");

        } catch (AuthenticationException e) {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {

        UserDetails userDetails = myUserDetailService.loadUserByUsername(userDTO.getEmail());
        if (userDetails == null) {
            userService.createUser(userDTO);
            return ResponseEntity.ok("User registered successfully");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User already exists");

    }

}
