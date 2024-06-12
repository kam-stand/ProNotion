package com.example.springboot.user.controller;

import com.example.springboot.user.model.User;
import com.example.springboot.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
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
        if (user.getUsername() == null || user.getPassword() == null || user.getEmail() == null
                || user.getPhone() == null) {
            return null;
        } else {

            return userService.save(user);
        }
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
        for (User u : userService.findAll()) {
            if (u.getUser_ID() == id) {
                if (user.getUsername() != null) {
                    u.setUsername(user.getUsername());
                }
                if (user.getPassword() != null) {
                    u.setPassword(user.getPassword());
                }
                if (user.getEmail() != null) {
                    u.setEmail(user.getEmail());
                }
                if (user.getPhone() != null) {
                    u.setPhone(user.getPhone());
                }
                if (user.getName() != null) {
                    u.setName(user.getName());
                }
                if (user.getTeamName() != null) {
                    u.setTeamName(user.getTeamName());
                }
                u.setUpdated_at(Date.from(Instant.now()));
                userService.save(u);
                return true;
            }
        }

        return false;
    }

}
