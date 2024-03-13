package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diver;


import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.seaCatch.SeaCatch;

public interface Diver {
    String getName();

    double getOxygen();

    boolean canDive();

    SeaCatch getSeaCatch();

    void shoot();
}
