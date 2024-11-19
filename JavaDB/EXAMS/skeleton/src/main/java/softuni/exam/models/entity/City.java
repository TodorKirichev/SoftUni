package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
public class City extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String cityName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Long population;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<Forecast> forecast;
}
