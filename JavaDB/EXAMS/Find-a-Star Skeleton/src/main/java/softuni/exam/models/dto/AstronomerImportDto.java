package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerImportDto {

    @XmlElement(name = "average_observation_hours")
    private Double averageObservationHours;

    @XmlElement
    private String birthday;

    @XmlElement(name = "first_name")
    private String firstName;

    @XmlElement(name = "last_name")
    private String lastName;

    @XmlElement
    private Double salary;

    @XmlElement(name = "observing_star_id")
    private Long observingStarId;
}
