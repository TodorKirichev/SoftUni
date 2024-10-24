package _2_;

import _1_.entities.Car;
import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "plate_numbers")
public class PlateNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "plateNumber")
    private Car car;

    private String number;

    public PlateNumber() {
    }

    public PlateNumber(String number) {
        this.number = number;
    }
}
