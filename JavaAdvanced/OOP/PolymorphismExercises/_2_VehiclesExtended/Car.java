package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._2_VehiclesExtended;

public class Car extends Vehicle {
    private final static double AC_FUEL_INCREASEMENT = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AC_FUEL_INCREASEMENT,tankCapacity);
    }

}
