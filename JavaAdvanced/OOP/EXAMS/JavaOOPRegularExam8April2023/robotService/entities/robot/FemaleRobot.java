package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.robot;

public class FemaleRobot extends BaseRobot {
    private static final int KILOGRAMS = 7;
    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        setKilograms(getKilograms() + 1);
    }
}
