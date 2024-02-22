package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._2_VehiclesExtended;

public class Truck extends Vehicle {
    private final static double AC_FUEL_INCREASEMENT = 1.6;
    private final static double FUEL_AFTER_RECHARGE = 0.95;

    protected Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AC_FUEL_INCREASEMENT, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * FUEL_AFTER_RECHARGE);
    }

}
