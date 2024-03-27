package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.tables;

public class Indoors extends BaseTable {
    private static final double PRICE_PER_PERSON = 4.50;
    public Indoors(int number, int size) {
        super(number, size, PRICE_PER_PERSON);
    }
}
