package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.astronauts;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
