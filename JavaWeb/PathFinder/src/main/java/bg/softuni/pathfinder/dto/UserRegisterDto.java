package bg.softuni.pathfinder.dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {

    @NotBlank
    private String username;

    @NotNull
    @Size(min = 5)
    private String fullName;

    @Email
    private String email;

    @Min(0)
    @Max(90)
    private Integer age;

    @Size(min = 5)
    private String password;

    @Size(min = 5)
    private String confirmPassword;

    @Override
    public String toString() {
        return "UserRegisterDto{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
