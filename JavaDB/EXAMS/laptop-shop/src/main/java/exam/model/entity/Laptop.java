package exam.model.entity;

import exam.model.enums.WarrantyType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

    @Column(name = "mac_address", unique = true, nullable = false)
    private String macAddress;

    @Column(name = "cpu_speed", nullable = false)
    private Double cpuSpeed;

    @Column(nullable = false)
    private Integer ram;

    @Column(nullable = false)
    private Integer storage;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    @Enumerated
    @Column(name = "warranty_type", nullable = false)
    private WarrantyType warrantyType;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
}
