package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.repositories;


import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.supplements.Supplement;

public interface Repository {

    void addSupplement(Supplement supplement);

    boolean removeSupplement(Supplement supplement);

    Supplement findFirst(String type);
}
