package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;

public class Carton implements Suitcase {
    private Collection<String> exhibits;

    public Carton() {
        exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return exhibits;
    }
}
