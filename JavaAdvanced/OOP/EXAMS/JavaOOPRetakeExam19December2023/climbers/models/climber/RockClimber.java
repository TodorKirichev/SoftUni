package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climber;

public class RockClimber extends BaseClimber{
    private static final double UNITS_OF_STRENGTH = 120;
    public RockClimber(String name) {
        super(name, UNITS_OF_STRENGTH);
    }

    @Override
    public void climb() {
        double decreasedStrength = getStrength() - 60;
        if (decreasedStrength <= 0) {
            setStrength(0);
        } else {
            setStrength(decreasedStrength);
        }
    }
}
