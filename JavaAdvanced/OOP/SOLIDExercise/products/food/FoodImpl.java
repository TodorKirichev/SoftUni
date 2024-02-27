package SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.food;

import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.ProductImpl;
import SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.interfaces.Food;

public abstract class FoodImpl extends ProductImpl implements Food {
    private double grams;

    public FoodImpl(double caloriesPer100, double grams) {
        super(caloriesPer100);
        this.grams = grams;
    }

    public double getTotalKg() {
        return grams / 1000;
    }

    @Override
    public double getCalories() {
        return grams * (getCaloriesPer100() / 100);
    }
}
