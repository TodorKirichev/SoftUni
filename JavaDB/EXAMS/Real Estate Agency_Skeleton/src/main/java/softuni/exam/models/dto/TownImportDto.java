package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TownImportDto {

    @Expose
    @NotNull
    @Size(min = 2)
    private String townName;

    @Expose
    @NotNull
    @Positive
    private Integer population;
}
