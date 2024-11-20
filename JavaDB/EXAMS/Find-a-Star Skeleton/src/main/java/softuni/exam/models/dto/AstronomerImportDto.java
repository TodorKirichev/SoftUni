package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerImportDto {

    @Min(value = 500)
    @XmlElement(name = "average_observation_hours")
    private Double averageObservationHours;

    @XmlElement
    private String birthday;

    @Size(min = 2, max = 30)
    @XmlElement(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 30)
    @XmlElement(name = "last_name")
    private String lastName;

    @Min(value = 15000)
    @XmlElement
    private Double salary;

    @XmlElement(name = "observing_star_id")
    private Long observingStar;
}
