package com.example.springboot.services;

import com.example.springboot.dto.UserDTO;
import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);


    }
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }




}
