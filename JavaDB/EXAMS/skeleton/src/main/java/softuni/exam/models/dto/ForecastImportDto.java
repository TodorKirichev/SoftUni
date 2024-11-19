package softuni.exam.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalTime;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastImportDto {

    @NotNull
    @XmlElement(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @DecimalMin(value = "-20")
    @DecimalMax(value = "60")
    @XmlElement(name = "max_temperature")
    private Double maxTemperature;

    @DecimalMin(value = "-50")
    @DecimalMax(value = "40")
    @XmlElement(name = "min_temperature")
    private Double minTemperature;

    @NotNull
    private String sunrise;

    @NotNull
    private String sunset;

    private Long city;
}
