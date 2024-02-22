package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._1_Vehicles;

import java.text.DecimalFormat;

public class Vehicle {
    double fuelQuantity;
    double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    public String drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;
        if (fuelNeeded > fuelQuantity) {
            return String.format("%s needs refueling",getClass().getSimpleName());
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            setFuelQuantity(getFuelQuantity() - fuelNeeded);
            return String.format("%s travelled %s km",getClass().getSimpleName(),df.format(distance));
        }
    }

    void refuel(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }
    @Override
    public String toString() {
        return String.format("%s: %.2f",getClass().getSimpleName(),fuelQuantity);
    }
}
