package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class StarImportDto {

    @Expose
    @Size(min = 2, max = 30)
    private String name;

    @Expose
    @Size(min = 6)
    private String description;

    @Expose
    private String starType;

    @Expose
    @Positive
    private Double lightYears;

    @Expose
    private Long constellation;
}
