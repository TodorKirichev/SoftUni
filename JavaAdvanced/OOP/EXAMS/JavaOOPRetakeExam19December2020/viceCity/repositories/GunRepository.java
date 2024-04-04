package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.repositories;


import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.guns.Gun;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {

    private Collection<Gun> models;

    public GunRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {
        if (!models.contains(model)) {
            models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return models.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }
}
