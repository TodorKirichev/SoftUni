package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiscovererRepository implements Repository<Discoverer> {
    private Collection<Discoverer> discoverers;

    public DiscovererRepository() {
        discoverers = new ArrayList<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(discoverers);
    }

    @Override
    public void add(Discoverer discoverer) {
        discoverers.add(discoverer);
    }

    @Override
    public boolean remove(Discoverer discoverer) {
        return discoverers.remove(discoverer);
    }

    @Override
    public Discoverer byName(String name) {
        return discoverers.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
}
