package SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.food;

public class Chips extends FoodImpl {
    public static final double CALORIES_PER_100_GRAMS = 529.0;
    public Chips(double grams) {
        super(CALORIES_PER_100_GRAMS, grams);
    }
}
