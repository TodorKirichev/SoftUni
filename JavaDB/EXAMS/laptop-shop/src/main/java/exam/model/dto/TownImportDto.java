package exam.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TownImportDto {

    @Size(min = 2)
    @NotNull
    @XmlElement
    private String name;

    @Positive
    @NotNull
    @XmlElement
    private Integer population;

    @Size(min = 10)
    @NotNull
    @XmlElement(name = "travel-guide")
    private String travelGuide;


}
