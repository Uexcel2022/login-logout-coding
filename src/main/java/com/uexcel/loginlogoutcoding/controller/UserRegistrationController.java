package com.uexcel.loginlogoutcoding.controller;

import com.uexcel.loginlogoutcoding.dto.UserDto;
import com.uexcel.loginlogoutcoding.repository.UserRepository;
import com.uexcel.loginlogoutcoding.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserRegistrationController {
     private  final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public  String getRegistrationPage(@ModelAttribute("user") UserDto userDto){
        return "registrationPage";
    }

    @PostMapping("/register")
    public  String getRegister(
            @ModelAttribute("user") UserDto userDto, Model model){
        if(!userDto.getPassword1().equals(userDto.getPassword2())){
            model.addAttribute("error","Password did not match!!!");
            return "registrationPage";
        }
        userService.saveUser(userDto);
            model.addAttribute("success","You have been registered successfully");
        return "registrationPage";
    }
}
