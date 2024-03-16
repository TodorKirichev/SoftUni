package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.entities.robot;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam8April2023.robotService.common.ExceptionMessages.*;

public abstract class BaseRobot implements Robot {
    private String name;
    private String kind;
    private int kilograms;
    private double price;

    public BaseRobot(String name, String kind, int kilograms, double price) {
        setName(name);
        setKind(kind);
        setKilograms(kilograms);
        setPrice(price);
    }

    private void setKind(String kind) {
        if (kind == null || kind.trim().isEmpty()) {
            throw new NullPointerException(ROBOT_KIND_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.kind = kind;
    }

    protected void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }

    private void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ROBOT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ROBOT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getKind() {
        return kind;
    }

    @Override
    public abstract void eating();
}
