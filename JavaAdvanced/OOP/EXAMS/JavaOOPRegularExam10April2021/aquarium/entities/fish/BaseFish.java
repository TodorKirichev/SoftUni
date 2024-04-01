package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.fish;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.common.ExceptionMessages.*;

public abstract class BaseFish implements Fish {
    private String name;
    private String species;
    private int size;
    private double price;

    public BaseFish(String name, String species, double price) {
        setName(name);
        setSpecies(species);
        setPrice(price);
    }

    protected void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new NullPointerException(SPECIES_NAME_NULL_OR_EMPTY);
        }
        this.species = species;
    }

    protected void setSize(int size) {
        if (price <= 0) {
            throw new IllegalArgumentException(FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.size = size;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FISH_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void eat() {
        size += 5;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
