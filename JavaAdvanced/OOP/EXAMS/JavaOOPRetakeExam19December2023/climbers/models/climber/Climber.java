package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.climber;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2023.climbers.models.roster.Roster;

public interface Climber {
    String getName();

    double getStrength();

    boolean canClimb();

    Roster getRoster();

    void climb();
}
