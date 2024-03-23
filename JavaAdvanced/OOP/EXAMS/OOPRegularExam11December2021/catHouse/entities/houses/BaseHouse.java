package SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.houses;

import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.cat.Cat;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (cats.size() == capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:", name, getClass().getSimpleName())).append(System.lineSeparator());
        sb.append("Cats: ");
        if (cats.isEmpty()) {
            sb.append("none");
        } else {
            String cats = getCats().stream().map(Cat::getName).collect(Collectors.joining(" "));
            sb.append(cats);
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Toys: %d Softness: %d", toys.size(), sumSoftness()));
        return sb.toString().trim();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
