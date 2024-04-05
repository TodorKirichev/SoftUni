package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam16August2020.onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer {
    private static final double OVERALLPERFORMANCE = 15;
    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, OVERALLPERFORMANCE);
    }
}
