package com.likebookapp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @Pattern(regexp = "^(?=.{3,20}$).+", message = "Username must be between 3 and 20 characters!")
    private String username;

    @NotBlank(message = "Email cannot be Empty!")
    @Email
    private String email;

    @Pattern(regexp = "^(?=.{3,20}$).+", message = "Password must be between 3 and 20 characters!")
    private String password;

    private String confirmPassword;
}
