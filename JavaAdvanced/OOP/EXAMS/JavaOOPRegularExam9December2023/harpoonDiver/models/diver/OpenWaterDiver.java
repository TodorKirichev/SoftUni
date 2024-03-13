package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diver;

public class OpenWaterDiver extends BaseDiver{
    private static final double UNITS_OF_OXYGEN = 30;
    public OpenWaterDiver(String name) {
        super(name, UNITS_OF_OXYGEN);
    }
}
