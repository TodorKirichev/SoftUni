package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column()
    private boolean discounted;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER)
    private List<Device> devices;

    @ManyToOne()
    @JoinColumn(name = "seller_id")
    private Seller seller;
}
