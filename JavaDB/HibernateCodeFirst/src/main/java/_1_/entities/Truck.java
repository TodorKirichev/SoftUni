package _1_.entities;

import _2_.Driver;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Truck extends Vehicle {

    @ManyToMany
    @JoinTable(
            name = "trucks_drivers",
            joinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id")
    )
    private List<Driver> drivers;

    private Double loadCapacity;

    public Truck(String model, BigDecimal price, String fuelType, Double loadCapacity) {
        super("truck", model, price, fuelType);
        this.loadCapacity = loadCapacity;
    }

    public Truck() {

    }
}
