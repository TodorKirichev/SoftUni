package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(name = "town_name", unique = true, nullable = false)
    private String townName;

    @Column(nullable = false)
    private Integer population;

    @OneToMany(mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Agent> agents;

    @OneToMany(mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Apartment> apartments;
}
