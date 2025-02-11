package com.likebookapp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import static com.likebookapp.util.ErrorMessages.*;

@Getter
@Setter
public class RegisterRequest {

    @Pattern(regexp = "^(?=.{3,20}$).+", message = USERNAME_INVALID)
    private String username;

    @NotBlank(message = EMAIL_NOT_BLANK)
    @Email(message = EMAIL_INVALID)
    private String email;

    @Pattern(regexp = "^(?=.{3,20}$).+", message = PASSWORD_INVALID)
    private String password;

    private String confirmPassword;
}
