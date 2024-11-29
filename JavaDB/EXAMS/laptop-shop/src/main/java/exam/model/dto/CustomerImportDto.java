package exam.model.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerImportDto {

    @Expose
    @NotNull
    @Size(min = 2)
    private String firstName;

    @Expose
    @NotNull
    @Size(min = 2)
    private String lastName;

    @Expose
    @NotNull
    @Email
    private String email;

    @Expose
    @NotNull
    private String registeredOn;

    @Expose
    @NotNull
    private TownDto town;
}
