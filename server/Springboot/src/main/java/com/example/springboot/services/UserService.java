package com.example.springboot.services;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;
    public String createUser(User user) {
        userRepository.save(user);
        String user_id = Long.toString(user.getUserId());
        return user_id;
    }
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
