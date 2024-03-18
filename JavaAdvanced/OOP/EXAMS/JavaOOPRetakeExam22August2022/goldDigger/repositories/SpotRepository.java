package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2022.goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot> {
    private Collection<Spot> spots;

    public SpotRepository() {
        spots = new ArrayList<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(spots);
    }

    @Override
    public void add(Spot spot) {
        spots.add(spot);
    }

    @Override
    public boolean remove(Spot spot) {
        return spots.remove(spot);
    }

    @Override
    public Spot byName(String name) {
        return spots.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}
