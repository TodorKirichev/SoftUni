package SoftUni.JavaAdvanced.OOP.PolymorphismExercises._2_VehiclesExtended;

public class Bus extends Vehicle {
    private final static double AC_FUEL_INCREASEMENT = 1.4;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AC_FUEL_INCREASEMENT, tankCapacity);
    }

    @Override
    public String driveEmpty (double distance) {
        setFuelConsumption(getFuelConsumption() - AC_FUEL_INCREASEMENT);
        String result = super.drive(distance);
        setFuelConsumption(getFuelConsumption() + AC_FUEL_INCREASEMENT);
        return result;
    }
}
