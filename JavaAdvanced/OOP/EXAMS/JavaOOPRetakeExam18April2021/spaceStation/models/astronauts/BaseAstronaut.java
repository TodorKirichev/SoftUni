package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.astronauts;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.bags.Backpack;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.models.bags.Bag;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2021.spaceStation.common.ExceptionMessages.*;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        bag = new Backpack();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        oxygen -= 10;
        if (oxygen < 0) {
            oxygen = 0;
        }
    }
}
