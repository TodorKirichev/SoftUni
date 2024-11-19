package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "light_years", nullable = false)
    private Double lightYears;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "star_type", nullable = false)
    private StarType starType;

    @OneToMany(mappedBy = "observingStar", fetch = FetchType.EAGER)
    List<Astronomer> observers;

    @ManyToOne
    @JoinColumn(name = "constellation_id")
    private Constellation constellation;
}
