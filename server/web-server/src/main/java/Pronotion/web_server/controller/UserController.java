package Pronotion.web_server.controller;

import Pronotion.web_server.dto.UserDto;
import Pronotion.web_server.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        userService.addUser(userDto.getName(), userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.ok("User registered successfully");
    }

//    @PostMapping("/api/user/register")
//    public ResponseEntity<?> loginUser(@RequestBody String email, String password) {
//
//    }
//


    @GetMapping("/api/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        if (userService.getUser(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/api/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userService.updateUser(id, userDto.getName(), userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.ok("User updated successfully");
    }

    @GetMapping("/api/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

}
