package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.diver;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.common.ExceptionMessages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.seaCatch.BaseSeaCatch;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam9December2023.harpoonDiver.models.seaCatch.SeaCatch;

public abstract class BaseDiver implements Diver{
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        seaCatch = new BaseSeaCatch();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
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
    public boolean canDive() {
        return oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return seaCatch;
    }

    @Override
    public void shoot() {
        oxygen = oxygen - 30;
        if (oxygen < 0) {
            oxygen = 0;
        }
    }
}
