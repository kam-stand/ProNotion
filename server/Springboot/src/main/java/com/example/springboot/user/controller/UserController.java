package com.example.springboot.user.controller;

import com.example.springboot.user.model.User;
import com.example.springboot.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/getAll")
    public List<User> getAllUsers() {
        return userService.findAll();

    }

    @PostMapping(path = "/newUser")
    public User newUser(@RequestBody User user) {
        return userService.save(user);

    }

    @GetMapping(path = "/getById")
    public User getUserById(@RequestParam("id") Long id) {
        for (User user : userService.findAll()) {
            if (user.getUser_ID() == id) {
                return user;
            }
        }
        return null;
    }

    @PostMapping(path = "/updateUser")
    public Boolean postMethodName(@RequestBody User user, long id) {
        // call the the user service to update the user
        User updatedUser = userService.update(user, id);
        // if the user is updated return true
        if (updatedUser != null) {
            return true;
        }
        return false;
    }

}
