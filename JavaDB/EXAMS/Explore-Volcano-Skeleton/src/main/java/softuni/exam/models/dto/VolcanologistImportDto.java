package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class VolcanologistImportDto {

    @Size(min = 2, max = 30)
    @XmlElement(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 30)
    @XmlElement(name = "last_name")
    private String lastName;

    @Positive
    @XmlElement
    private Double salary;

    @Min(value = 18)
    @Max(value = 80)
    @XmlElement
    private Integer age;

    @XmlElement(name = "exploring_from")
    private String exploringFrom;

    @XmlElement(name = "exploring_volcano_id")
    private Long exploringVolcanoId;
}
