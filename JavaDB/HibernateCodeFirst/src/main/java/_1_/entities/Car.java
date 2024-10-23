package _1_.entities;

import _2_.PlateNumber;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;

@Entity
public class Car extends Vehicle {

    @OneToOne
    @JoinColumn(name = "plate_number_id", referencedColumnName = "id")
    private PlateNumber plateNumber;

    private Integer seats;

    public Car(String model, BigDecimal price, String fuelType, Integer seats, PlateNumber plateNumber) {
        super("car", model, price, fuelType);
        this.seats = seats;
        this.plateNumber = plateNumber;
    }

    public Car() {
    }
}
