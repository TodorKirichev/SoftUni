package softuni.exam.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class VisitorImportDto {

    @Size(min = 2, max = 20)
    @NotNull
    @XmlElement(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 20)
    @NotNull
    @XmlElement(name = "last_name")
    private String lastName;

    @NotNull
    @XmlElement(name = "attraction_id")
    private Long attractionId;

    @NotNull
    @XmlElement(name = "country_id")
    private Long countryId;

    @NotNull
    @XmlElement(name = "personal_data_id")
    private Long personalDataId;
}
