package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.team;

public class Bulgaria extends BaseTeam {
    public Bulgaria(String name, String country, int advantage) {
        super(name, country, advantage);
    }

    @Override
    public void play() {
        setAdvantage(getAdvantage() + 115);
    }
}
