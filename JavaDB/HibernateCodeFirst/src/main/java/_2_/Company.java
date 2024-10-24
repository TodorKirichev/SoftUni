package _2_;

import _1_.entities.Plane;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "company")
    private List<Plane> planes;

    private String name;

    public Company() {
        this.planes = new ArrayList<>();
    }
}
