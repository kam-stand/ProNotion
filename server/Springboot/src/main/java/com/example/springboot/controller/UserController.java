package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.services.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }
    @PostMapping("/postUser")
    public ResponseEntity<String> postUser(@RequestBody User newUser){
        userService.createUser(newUser);
        return ResponseEntity.status(200).body(newUser.toString());
    }
    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam("id") long id){
        return ResponseEntity.status(200).body(userService.getUserById(id));
    }
}
