package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.bakedFoods;

public class Cake extends BaseFood {
    private static final double INITIAL_PORTION = 245;
    public Cake(String name, double price) {
        super(name, INITIAL_PORTION, price);
    }
}
