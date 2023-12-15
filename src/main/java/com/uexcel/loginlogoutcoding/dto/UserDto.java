package com.uexcel.loginlogoutcoding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String fullName;
    private String email;
    private String password1;
    private String password2;
}
