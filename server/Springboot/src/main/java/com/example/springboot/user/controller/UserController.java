package com.example.springboot.user.controller;
import com.example.springboot.user.model.User;
import com.example.springboot.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/getAll")
    public List<User> getAllUsers() {
        return userService.findAll();

    }
    @PostMapping(path ="/newUser")
    public User newUser(@RequestBody User user) {
        if (user.getUsername() == null || user.getPassword() == null || user.getEmail() == null || user.getPhone() == null) {
            return null;
        }
        else{
            return userService.save(user);
        }
    }
    @GetMapping(path = "/getById")
    public User getUserById(@RequestParam("id") Long id) {
        for (User user : userService.findAll()) {
            if(user.getUser_ID() == id){
                return user;
            }
        }
        return null;
    }

}
