package Pronotion.web_server.controller;

import Pronotion.web_server.dto.UserDto;
import Pronotion.web_server.model.User;
import Pronotion.web_server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        userService.addUser(userDto.getName(), userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/api")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok("get users");
    }

}
