package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._1_Vehicles;

public class Car extends Vehicle{
    public final static double AC_FUEL_INCREASEMENT = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_FUEL_INCREASEMENT);
    }

}
