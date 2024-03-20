package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.player;

public class Women extends BasePlayer {
    private static final double INITIAL_WEIGHT = 60.00;
    public Women(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_WEIGHT, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 115);
    }
}
