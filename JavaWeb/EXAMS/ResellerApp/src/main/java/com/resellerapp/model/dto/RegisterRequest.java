package com.resellerapp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "Username must be between 3 and 20 symbols")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 symbols")
    private String username;

    @NotBlank(message = "Enter a valid email")
    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "Password must be between 3 and 20 symbols")
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 symbols")
    private String password;

    private String confirmPassword;
}
