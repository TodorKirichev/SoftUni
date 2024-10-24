package _2_;

import _1_.entities.Truck;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "drivers")
    private List<Truck> trucks;

    @Column(name = "full_name")
    private String fullName;

    public Driver() {
    }
}
