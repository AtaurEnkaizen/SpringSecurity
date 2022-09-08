package com.example.SpringSecurity.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RegistrationModel {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
