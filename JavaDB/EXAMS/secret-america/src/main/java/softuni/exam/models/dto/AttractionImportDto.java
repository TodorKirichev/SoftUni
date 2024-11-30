package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionImportDto {

    @Expose
    @NotNull
    @Size(min = 5, max = 40)
    private String name;

    @Expose
    @NotNull
    @Size(min = 10, max = 100)
    private String description;

    @Expose
    @NotNull
    @Size(min = 3, max = 30)
    private String type;

    @Expose
    @NotNull
    @Min(0)
    private Integer elevation;

    @Expose
    @NotNull
    private Long country;
}
