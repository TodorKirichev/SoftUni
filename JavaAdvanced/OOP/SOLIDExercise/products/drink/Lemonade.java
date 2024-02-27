package SoftUni.JavaAdvanced.OOP.SOLIDExercise.products.drink;

public class Lemonade extends DrinkImpl {

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    public Lemonade(double milliliters) {
        super(CALORIES_PER_100_GRAMS, milliliters, DENSITY);
    }

}
