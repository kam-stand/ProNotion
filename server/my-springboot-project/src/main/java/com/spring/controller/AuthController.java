 package com.spring.controller;

import com.spring.auth.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto LoginDto){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(LoginDto.getUsername(), LoginDto.getPassword()));
        if(authentication.isAuthenticated()){
            String token =jwtService.generateToken(LoginDto.getUsername());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
            // send a response back to client of JWT 
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        

    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {

        if(userService.isValid(userDto)){
            userService.createUser(userDto);
            // send a response back to client of JWT
            String token = jwtService.generateToken(userDto.getEmail());
        return new ResponseEntity<>(token, HttpStatus.CREATED);

        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    


    
}