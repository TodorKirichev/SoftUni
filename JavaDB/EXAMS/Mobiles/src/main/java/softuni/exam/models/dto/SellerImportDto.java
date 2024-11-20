package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SellerImportDto {

    @NotNull
    @Size(min = 2, max = 30)
    @Expose
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    @Expose
    private String lastName;

    @NotNull
    @Size(min = 3, max = 6)
    @Expose
    private String personalNumber;
}
