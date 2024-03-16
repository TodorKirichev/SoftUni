package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.supplements;

public abstract class BaseSupplement implements  Supplement {
    private int hardness;
    private double price;

    public BaseSupplement(int hardness, double price) {
        this.hardness = hardness;
        this.price = price;
    }

    @Override
    public int getHardness() {
        return hardness;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
