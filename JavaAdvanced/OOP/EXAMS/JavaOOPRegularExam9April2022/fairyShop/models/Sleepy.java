package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9April2022.fairyShop.models;

public class Sleepy extends BaseHelper {
    private static final int ENERGY = 50;
    public Sleepy(String name) {
        super(name, ENERGY);
    }

    @Override
    public void work() {
        setEnergy(getEnergy() - 15);
        if (getEnergy() < 0) {
            setEnergy(0);
        }
    }
}
