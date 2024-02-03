package JavaAdvanced.DefiningClassesExercises._3_SpeedRacing;

public class Car {
    String model;
    double fuelAmount;
    double fuelPer1Km;
    double distanceTravelled;

    public Car(String model, double fuelAmount, double fuelPer1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPer1Km = fuelPer1Km;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
    public double getDistanceTravelled() {
        return distanceTravelled;
    }
    public void drive(double distance) {
        if (fuelAmount >= distance * fuelPer1Km) {
            fuelAmount -= distance * fuelPer1Km;
            distanceTravelled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }
}
