package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class VolcanoImportDto {

    @Size(min = 2, max = 30)
    @Expose
    private String name;

    @Positive
    @Expose
    private Integer elevation;

    @Expose
    private String volcanoType;

    @Expose
    private boolean isActive;

    @Expose
    private String lastEruption;

    @Expose
    private Long country;
}
