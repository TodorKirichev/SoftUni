package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;

    @Column(name = "personal_number", unique = true, nullable = false)
    private String personalNumber;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private List<Sale> sales;
}
