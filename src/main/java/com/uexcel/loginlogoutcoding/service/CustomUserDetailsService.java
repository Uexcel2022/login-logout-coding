package com.uexcel.loginlogoutcoding.service;

import com.uexcel.loginlogoutcoding.entity.User;
import com.uexcel.loginlogoutcoding.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user==null){
            throw new RuntimeException("User Not Found");
        }

        return new CustomUserDetails(user);
    }
}
