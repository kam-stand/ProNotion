package com.spring.auth.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class CustomUserService implements UserDetailsService{


    @Autowired
    UserRepository userRepository;

    public CustomUserService(){

    }


    @Autowired
    public CustomUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDto = userRepository.findByEmail(username);
        User user = userDto.orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));

        return new CustomerUserDetails(user);
       
    }

}