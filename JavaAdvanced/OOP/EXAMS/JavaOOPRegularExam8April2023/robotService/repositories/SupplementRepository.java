package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;

public class SupplementRepository implements Repository {
    private Collection<Supplement> supplements;

    public SupplementRepository() {
        this.supplements = new ArrayList<>();
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public boolean removeSupplement(Supplement supplement) {
        return supplements.remove(supplement);
    }

    @Override
    public Supplement findFirst(String type) {
        return supplements.stream().filter(s -> s.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
