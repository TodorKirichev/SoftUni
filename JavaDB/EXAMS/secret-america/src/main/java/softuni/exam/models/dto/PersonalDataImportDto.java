package softuni.exam.models.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class PersonalDataImportDto {

    @Min(value = 1)
    @Max(value = 100)
    @XmlElement
    private Integer age;

    @XmlElement
    private String gender;

    @XmlElement(name = "birth_date")
    private String birthDate;

    @Size(min = 9, max = 9)
    @NotNull
    @XmlElement(name = "card_number")
    private String cardNumber;
}
