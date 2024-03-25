package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2021.glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;

public class ExplorerRepository implements Repository<Explorer> {
    private Collection<Explorer> explorers;

    public ExplorerRepository() {
        explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return explorers;
    }

    @Override
    public void add(Explorer explorer) {
        explorers.add(explorer);
    }

    @Override
    public boolean remove(Explorer explorer) {
        return explorers.remove(explorer);
    }

    @Override
    public Explorer byName(String name) {
        return explorers.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }
}
