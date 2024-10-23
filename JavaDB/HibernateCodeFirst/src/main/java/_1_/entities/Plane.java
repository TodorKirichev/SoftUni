package _1_.entities;

import _2_.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

@Entity
public class Plane extends Vehicle {

    @ManyToOne
    private Company company;

    private Integer passengerCapacity;

    public Plane(String model, BigDecimal price, String fuelType, Integer passengerCapacity) {
        super("plane", model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
    }

    public Plane() {

    }
}
