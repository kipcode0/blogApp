package com.kipcode.blogapp.registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Registration {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
