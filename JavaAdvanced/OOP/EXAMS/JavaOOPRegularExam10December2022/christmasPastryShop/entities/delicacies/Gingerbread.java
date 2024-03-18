package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.delicacies;

public class Gingerbread extends BaseDelicacy {
    private static final double InitialGingerbreadPortion = 200;
    public Gingerbread(String name, double price) {
        super(name, InitialGingerbreadPortion, price);
    }
}
