package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.entities.cars;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model,int min, int max,  int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(min, max, horsePower);
        setCubicCentimeters(cubicCentimeters);
    }

    protected void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    protected void setHorsePower(int min, int max, int horsePower) {
        if (horsePower < min || horsePower > max) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        this.horsePower = horsePower;
    }

    protected void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
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
