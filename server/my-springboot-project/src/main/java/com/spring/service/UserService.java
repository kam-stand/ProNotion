package com.spring.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.dto.UserDto;
import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(UserDto userDto) {
        System.out.println(userDto.toString() + "     " + userDto.getPassword());
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRole(userDto.getRole());
        user.setCreatedAt(new Date());

        userRepository.save(user);
    }

    public long getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get().getId();
        }
        return -1;

    }

   

    public boolean isValid(UserDto userDto){
        if(!(userDto.getEmail().contains("@"))){
            return false;
        }
        if (!(userDto.getPassword().length()<10)){
            return false;
        }

        return true;
    }



}
