package ru.kpfu.itis.form;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    private String lastName;
    private String firstName;
    private String email;
    private String password;


    }