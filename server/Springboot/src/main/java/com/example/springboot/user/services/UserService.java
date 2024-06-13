package com.example.springboot.user.services;

import com.example.springboot.user.model.User;
import com.example.springboot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.roles.Membership;

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

    public User update(User user, Long id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            return userRepository.save(existingUser);
        }
        return null;
    }

    public User changeMemberShip(long id, String membership) {
        User user = userRepository.findById(id).orElse(null);
        Membership membership1 = Membership.valueOf(membership.toUpperCase());
        if (user != null) {
            user.setMembership(membership1);
            return userRepository.save(user);
        }
        return null;

    }

}
