package exam.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double income;

    @Column(nullable = false)
    private String address;

    @Column(name = "employee_count", nullable = false)
    private Integer employeeCount;

    @Column(name = "shop_area", nullable = false)
    private Integer shopArea;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;

    @OneToMany(mappedBy = "shop", fetch = FetchType.EAGER)
    private Set<Laptop> laptops;
}
