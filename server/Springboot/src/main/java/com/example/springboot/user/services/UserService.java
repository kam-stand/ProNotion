package com.example.springboot.user.services;

import com.example.springboot.user.model.User;
import com.example.springboot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.roles.Membership;
import com.example.springboot.roles.Role;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        if (isValidUser(user)) {
            setDefaultValues(user);
            return userRepository.save(user);
        }
        return null;
    }

    private boolean isValidUser(User user) {
        return user.getName() != null && user.getEmail() != null && user.getPhone() != null;
    }

    private void setDefaultValues(User user) {
        Instant now = Instant.now();
        user.setCreated_at(Optional.ofNullable(user.getCreated_at()).orElse(Date.from(now)));
        user.setMembership(Optional.ofNullable(user.getMembership()).orElse(Membership.BASIC));
        user.setRole(Optional.ofNullable(user.getRole()).orElse(Role.USER));
        user.setUpdated_at(Date.from(now));
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
        User u = userRepository.findById(id).orElse(null);
        if (u != null) {
            if (user.getName() != null)
                u.setName(user.getName());
            if (user.getEmail() != null)
                u.setEmail(user.getEmail());
            if (user.getPhone() != null)
                u.setPhone(user.getPhone());
            if (user.getTeamName() != null)
                u.setTeamName(user.getTeamName());
            if (user.getRole() != null)
                u.setRole(user.getRole());
            if (user.getMembership() != null)
                u.setMembership(user.getMembership());
            u.setUpdated_at(Date.from(Instant.now())); // Always update the timestamp
            if (user.getTasks() != null)
                u.setTasks(user.getTasks());
            if (user.getAssigned_tasks() != null)
                u.setAssigned_tasks(user.getAssigned_tasks());
            return userRepository.save(u); // Save only once
        }
        return null;
    }

    public User changeMemberShip(long id, String membership) {
        User user = userRepository.findById(id).orElse(null);
        // check if the membership is valid
        if (user != null) {
            if (membership.toUpperCase().equals("BASIC")) {
                user.setMembership(Membership.BASIC);
            } else if (membership.toUpperCase().equals("ADVANCED")) {
                user.setMembership(Membership.ADVANCED);
            } else if (membership.toUpperCase().equals("ENTERPRISE")) {
                user.setMembership(Membership.ENTERPRISE);
            } else {
                return null;
            }
            return userRepository.save(user);
        }
        return null;

    }

}
