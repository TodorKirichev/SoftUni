package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "volcanoes")
public class Volcano extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer elevation;

    @Column(name = "volcano_type")
    @Enumerated(EnumType.STRING)
    private VolcanoType volcanoType;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "last_eruption")
    private LocalDate lastEruption;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "volcano")
    private Set<Volcanologist> volcanologists;
}
