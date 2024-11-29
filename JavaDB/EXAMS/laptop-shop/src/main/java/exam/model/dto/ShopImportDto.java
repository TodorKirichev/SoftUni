package exam.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
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
public class ShopImportDto {

    @Size(min = 4)
    @NotNull
    @XmlElement
    private String name;

    @Size(min = 4)
    @NotNull
    @XmlElement
    private String address;

    @Min(value = 1)
    @Max(value = 50)
    @NotNull
    @XmlElement(name = "employee-count")
    private Integer employeeCount;

    @Min(value = 20000)
    @NotNull
    @XmlElement
    private Double income;

    @Min(value = 150)
    @NotNull
    @XmlElement(name = "shop-area")
    private Integer shopArea;

    @NotNull
    @XmlElement
    private TownDto town;
}
