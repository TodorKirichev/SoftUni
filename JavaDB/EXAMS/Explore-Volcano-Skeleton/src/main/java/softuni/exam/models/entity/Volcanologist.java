package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "volcanologists")
public class Volcanologist extends BaseEntity {

    @Column(name = "first_name", nullable = false, unique = true)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    private String lastName;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private Integer age;

    @Column(name = "exploring_from")
    private LocalDate exploringFrom;

    @ManyToOne
    @JoinColumn(name = "exploring_volcano_id")
    private Volcano volcano;
}
