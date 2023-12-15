package com.uexcel.loginlogoutcoding.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users", uniqueConstraints =
@UniqueConstraint(name = "email_unique", columnNames={"email"}
))
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
}
