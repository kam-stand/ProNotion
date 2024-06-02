package com.example.springboot.user.services;

import com.example.springboot.user.model.User;
import com.example.springboot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User save(User user) {
        return userRepository.save(user);
    }
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    public User update(User user) {
        return userRepository.save(user);
    }

}
