
package com.spring.auth.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.spring.model.User;

@Component
public class CustomerUserDetails  implements UserDetails{

    private User user;

    CustomerUserDetails(){

    }

    CustomerUserDetails(User user){
        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
        return roles;

    }

    @Override
    public String getPassword() {
        return user.getPassword();
     }

    @Override
    public String getUsername() {

        return user.getEmail();
     }



    
}