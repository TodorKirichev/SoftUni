package SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.food;

public class Chocolate extends FoodImpl {

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    public Chocolate(double grams) {
        super(CALORIES_PER_100_GRAMS, grams);
    }

}
