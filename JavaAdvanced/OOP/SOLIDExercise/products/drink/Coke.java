package SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.drink;

public class Coke extends DrinkImpl {

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    public Coke(double milliliters) {
        super(CALORIES_PER_100_GRAMS, milliliters, DENSITY);
    }

}
