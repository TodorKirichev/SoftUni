package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ConstellationImportDto {

    @Expose
    @Size(min = 3, max = 20)
    private String name;

    @Expose
    @Size(min = 5)
    private String description;
}
