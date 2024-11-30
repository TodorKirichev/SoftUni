package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryImportDto {

    @Expose
    @NotNull
    @Size(min = 3, max = 40)
    private String name;

    @Expose
    @Positive
    private Double area;
}
