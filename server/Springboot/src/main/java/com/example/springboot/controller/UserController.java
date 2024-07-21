package com.example.springboot.controller;

import com.example.springboot.dto.UserDTO;
import com.example.springboot.model.User;
import com.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/getUsers")
    public List<User> getAll(){
        return  userService.getAllUsers();

    }
    @PostMapping("/postUser")
    public ResponseEntity<String> postUser(@RequestBody UserDTO newUser){
        userService.createUser(newUser);
        return ResponseEntity.status(200).body(newUser.toString());
    }
    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam("id") long id){
        return ResponseEntity.status(200).body(userService.getUserById(id));
    }



}
