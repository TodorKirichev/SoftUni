package com.philately.model.dto;

import com.philately.validation.ValidInputLength;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @ValidInputLength(message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Email cannot be empty")
    @Email
    private String email;

    @ValidInputLength(message = "Password must be between 3 and 20 characters")
    private String password;

    private String confirmPassword;
}
