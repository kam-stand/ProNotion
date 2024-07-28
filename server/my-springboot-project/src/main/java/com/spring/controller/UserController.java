package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.dto.TaskDto;
import com.spring.dto.UserDto;
import com.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> PostUser(@RequestBody UserDto userDto) {
        try {
            userService.createUser(userDto);
            return ResponseEntity.ok("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating user");
        }
    }

    @PostMapping("/task")
    public ResponseEntity<?> PostTaskToUser(@RequestParam Long userId, @RequestBody TaskDto taskDto) {
        try {
            userService.addTaskToUser(userId, taskDto);
            return ResponseEntity.ok("Task added to user successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding task to user");
        }
    }

}
