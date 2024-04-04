package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.entities.cars.Car;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CarRepository implements Repository<Car> {
    private Collection<Car> models;

    public CarRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return models.stream().filter(c -> c.getModel().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Car model) {
        models.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return models.remove(model);
    }
}
