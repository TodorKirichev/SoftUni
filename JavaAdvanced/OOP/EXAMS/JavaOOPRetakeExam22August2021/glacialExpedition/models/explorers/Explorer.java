package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.explorers;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.suitcases.Suitcase;

public interface Explorer {
    String getName();

    double getEnergy();

    boolean canSearch();

    Suitcase getSuitcase();

    void search();
}
