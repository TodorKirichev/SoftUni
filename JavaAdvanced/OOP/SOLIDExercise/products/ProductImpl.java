package SoftUni.JavaAdvanced.OOP.SOLIDExercise.products;

public class ProductImpl {
    double caloriesPer100;

    public ProductImpl(double caloriesPer100) {
        this.caloriesPer100 = caloriesPer100;
    }

    public double getCaloriesPer100() {
        return caloriesPer100;
    }
}
