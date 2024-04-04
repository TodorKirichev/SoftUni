package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.drinks;

public class Water extends BaseDrink {
    private static final double PRICE = 1.50;
    public Water(String name, int portion, String brand) {
        super(name, portion, PRICE, brand);
    }
}
