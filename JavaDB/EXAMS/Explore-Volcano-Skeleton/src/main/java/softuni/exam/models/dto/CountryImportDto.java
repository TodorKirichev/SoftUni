package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class CountryImportDto {

    @Size(min = 3, max = 30)
    @Expose
    private String name;

    @Size(min = 3, max = 30)
    @Expose
    private String capital;
}
