package _1_.entities;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Bike extends Vehicle {

    public Bike(String model, BigDecimal price, String fuelType) {
        super("bike", model, price, fuelType);
    }

    public Bike() {
    }
}
