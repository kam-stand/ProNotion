package com.example.springboot.controller;

import com.example.springboot.dto.UserDTO;
import com.example.springboot.model.User;
import com.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/getUsers")
    @PreAuthorize("hasAnyRole(ADMIN)")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    @PostMapping("/postUser")
    public ResponseEntity<String> postUser(@RequestBody UserDTO newUser){
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userService.createUser(newUser);
        return ResponseEntity.status(200).body(newUser.toString());
    }
    @GetMapping("/getUserById")
    @PreAuthorize("hasAnyRole(ADMIN)")
    public ResponseEntity<User> getUserById(@RequestParam("id") long id){
        return ResponseEntity.status(200).body(userService.getUserById(id));
    }



}
