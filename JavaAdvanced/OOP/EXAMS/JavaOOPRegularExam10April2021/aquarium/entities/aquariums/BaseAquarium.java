package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.aquariums;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.decorations.Decoration;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        decorations = new ArrayList<>();
        fish = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", name, getClass().getSimpleName())).append(System.lineSeparator());
        sb.append("Fish: ");
        if (fish.isEmpty()) {
            sb.append("none");
        } else {
            sb.append(fish.stream().map(Fish::getName).collect(Collectors.joining(" ")));
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Decorations: %d", decorations.size())).append(System.lineSeparator());
        sb.append(String.format("Comfort: %d", calculateComfort()));
        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return null;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return null;
    }
}
