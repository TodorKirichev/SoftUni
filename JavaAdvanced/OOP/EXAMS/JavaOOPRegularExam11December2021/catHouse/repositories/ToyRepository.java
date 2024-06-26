package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam11December2021.catHouse.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam11December2021.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public class ToyRepository implements Repository {
    private Collection<Toy> toys;

    public ToyRepository() {
        toys = new ArrayList<>();
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public boolean removeToy(Toy toy) {
        return toys.remove(toy);
    }

    @Override
    public Toy findFirst(String type) {
        return toys.stream().filter(t -> t.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
