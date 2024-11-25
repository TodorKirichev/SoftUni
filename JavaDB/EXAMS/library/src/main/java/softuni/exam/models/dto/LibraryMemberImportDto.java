package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LibraryMemberImportDto {

    @Expose
    @Size(min = 2, max = 40)
    private String address;

    @Expose
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @Expose
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @Expose
    @NotNull
    @Size(min = 2, max = 20)
    private String phoneNumber;
}
