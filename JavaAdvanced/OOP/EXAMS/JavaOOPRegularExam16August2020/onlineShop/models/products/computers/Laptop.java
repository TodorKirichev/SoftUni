package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.computers;

public class Laptop extends BaseComputer {
    private static final double OVERALLPERFORMANCE = 10;
    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, OVERALLPERFORMANCE);
    }
}
