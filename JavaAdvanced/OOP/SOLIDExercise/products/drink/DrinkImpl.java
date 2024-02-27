package SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.drink;

import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.interfaces.Drink;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.ProductImpl;

public abstract class DrinkImpl extends ProductImpl implements Drink {
    private double milliliters;

    private double density;

    public DrinkImpl(double caloriesPer100, double milliliters, double density) {
        super(caloriesPer100);
        this.milliliters = milliliters;
        this.density = density;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        double grams = milliliters * density;
        return grams * (getCaloriesPer100() / 100);
    }

    @Override
    public double getTotalKg() {
        return (milliliters / 1000) * density;
    }

    @Override
    public double getTotalLiters() {
        return milliliters / 1000;
    }
}
