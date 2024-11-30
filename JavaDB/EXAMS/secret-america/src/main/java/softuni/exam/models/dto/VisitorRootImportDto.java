package softuni.exam.models.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "visitors")
@XmlAccessorType(XmlAccessType.FIELD)
public class VisitorRootImportDto {

    @XmlElement(name = "visitor")
    private List<VisitorImportDto> visitorImportDtos;
}
