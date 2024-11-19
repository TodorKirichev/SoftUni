package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Double salary;

    @Column(name = "average_observation_hours", nullable = false)
    private Double averageObservationHours;

    @Column
    private LocalDate birthday;

    @ManyToOne
    private Star observingStar;
}
