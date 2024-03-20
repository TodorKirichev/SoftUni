package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.player;

public class Men extends BasePlayer {
    private static final double INITIAL_WEIGHT = 85.00;
    public Men(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_WEIGHT, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 145);
    }
}
