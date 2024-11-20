package softuni.exam.models.dto;

import lombok.Getter;
import lombok.Setter;

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
public class DeviceImportDto {

    @NotNull
    @Size(min = 2, max = 20)
    @XmlElement
    private String brand;

    @XmlElement(name = "device_type")
    private String deviceType;

    @NotNull
    @Size(min = 1, max = 20)
    @XmlElement
    private String model;

    @XmlElement
    private Double price;

    @XmlElement
    private Integer storage;

    @XmlElement(name = "sale_id")
    private Long sale;
}
