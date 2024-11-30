package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttractionImportDto {

    private String name;

    private String description;

    private String type;

    private Integer elevation;

    private Long country;
}
