package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.healthyFoods;

public class VeganBiscuits extends Food {
    private static final double INITIAL_PORTION = 205;
    public VeganBiscuits(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
