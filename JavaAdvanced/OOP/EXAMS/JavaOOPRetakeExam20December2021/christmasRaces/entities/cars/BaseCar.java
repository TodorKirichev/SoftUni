package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.cars;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        this.horsePower = horsePower;
        this.cubicCentimeters = cubicCentimeters;
    }

    protected void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    protected void setHorsePower(int horsePower, int minHorsePower, int maxHorsePower) {
        if (horsePower < minHorsePower || horsePower > maxHorsePower) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return cubicCentimeters / horsePower * laps;
    }
}
