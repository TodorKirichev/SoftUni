package softuni.exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column
    private Double area;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "country")
    @Column(nullable = false)
//    -------------------------------------------------
    private Set<Attraction> attractions;

    @Column(nullable = false)
    @OneToMany(mappedBy = "country")
    private Set<Visitor> visitors;
}
