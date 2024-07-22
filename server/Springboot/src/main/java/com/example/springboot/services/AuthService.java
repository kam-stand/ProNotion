package com.example.springboot.services;

import com.example.springboot.dto.RegistrationRequest;
import com.example.springboot.dto.UserDTO;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapReactiveUserDetailsService reactiveUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    public ResponseEntity<?> authenticate(RegistrationRequest registrationRequest) {
        boolean exists = userRepository.existsByEmail(registrationRequest.getEmail());
        if (exists) {
            return ResponseEntity.status(401).body("Email already exists");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(registrationRequest.getEmail());
        userDTO.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userDTO.setLastName(registrationRequest.getLastName());
        userDTO.setFirstName(registrationRequest.getFirstName());
        userService.createUser(userDTO);

        return null;
    }
}
