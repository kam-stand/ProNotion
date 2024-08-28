 package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.dto.UserDto;
import com.spring.dto.auth.LoginDto;
import com.spring.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;


    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(@RequestBody LoginDto LoginDto){

        
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(LoginDto.getUsername(), LoginDto.getPassword()));
        
        if(!authentication.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authentication);
            authentication.setAuthenticated(true);
    
        }
        
        

        return "youre logged in";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));

    }

    
}