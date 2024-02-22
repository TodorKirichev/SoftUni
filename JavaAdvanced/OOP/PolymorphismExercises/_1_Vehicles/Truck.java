package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._1_Vehicles;

public class Truck extends Vehicle{
    public final static double AC_FUEL_INCREASEMENT = 1.6;
    public final static double FUEL_AFTER_RECHARGE = 0.95;

    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_FUEL_INCREASEMENT);
    }
    @Override
    public void refuel(double liters) {
        super.refuel(liters * FUEL_AFTER_RECHARGE);
    }

}
