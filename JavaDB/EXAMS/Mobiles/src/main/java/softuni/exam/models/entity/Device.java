package softuni.exam.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "devices")
public class Device extends BaseEntity {

    @Column(nullable = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column
    private DeviceType deviceType;

    @Column(unique = true, nullable = false)
    private String model;

    @Column
    private Double price;

    @Column
    private Integer storage;

    @ManyToOne()
    @JoinColumn(name = "sale_id")
    private Sale sale;
}
