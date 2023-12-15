package com.uexcel.loginlogoutcoding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "login-page";
    }

    @GetMapping("/admin-page")
    public String getAdminPage(){
        return "adminPage";
    }

    @GetMapping("/user-page")
    public String getUserPage(){
        return "userPage";
    }

}
