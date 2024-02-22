package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._2_VehiclesExtended;

import java.text.DecimalFormat;

public class Vehicle {
    double fuelQuantity;
    double fuelConsumption;
    double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;
        if (fuelNeeded > fuelQuantity) {
            return String.format("%s needs refueling", getClass().getSimpleName());
        } else {
            fuelQuantity -= fuelNeeded;
            DecimalFormat df = new DecimalFormat("#.##");
            return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
        }
    }

    public String driveEmpty(double distance) {
        return drive(distance);
    }

    void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity + liters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", getClass().getSimpleName(), fuelQuantity);
    }
}
