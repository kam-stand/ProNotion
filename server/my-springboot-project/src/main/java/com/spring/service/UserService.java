package com.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.dto.UserDto;
import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserDto userDto) {
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword());
        userRepository.save(user);
        return userDto;
    }

    public UserDto getUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            return new UserDto(user.get().getFirstName(), user.get().getLastName(), user.get().getEmail(),
                    user.get().getPassword());
        }
        return null;
    }

}
