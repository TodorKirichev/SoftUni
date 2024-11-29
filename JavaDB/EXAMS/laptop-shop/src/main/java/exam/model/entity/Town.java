package exam.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer population;

    @Column(name = "travel_guide", nullable = false, columnDefinition = "TEXT")
    private String travelGuide;

    @OneToMany(mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Shop> shops;

    @OneToMany(mappedBy = "town", fetch = FetchType.EAGER)
    private Set<Customer> customers;
}
