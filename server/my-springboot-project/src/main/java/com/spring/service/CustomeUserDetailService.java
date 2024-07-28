
package com.spring.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class CustomeUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomeUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(username);
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Invalid username or password"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRole().name()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role) {
        return List.of(new SimpleGrantedAuthority(role));
    }
}
