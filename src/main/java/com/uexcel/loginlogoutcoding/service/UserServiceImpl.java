package com.uexcel.loginlogoutcoding.service;

import com.uexcel.loginlogoutcoding.dto.UserDto;
import com.uexcel.loginlogoutcoding.entity.User;
import com.uexcel.loginlogoutcoding.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private  final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setFullName(user.getFullName());
        user.setEmail(userDto.getEmail());
        user.setPassword(
                new BCryptPasswordEncoder(11)
                        .encode(userDto.getPassword1()));
        user.setRole("USER");
        userRepository.save(user);

    }
}
