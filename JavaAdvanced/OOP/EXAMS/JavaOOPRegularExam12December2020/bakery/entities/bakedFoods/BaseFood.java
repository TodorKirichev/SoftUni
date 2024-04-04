package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.bakedFoods;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.bakedFoods.interfaces.BakedFood;

public abstract class BaseFood implements BakedFood {
    private String name;
    private double portion;
    private double price;

    public BaseFood(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or white space!");
        }
        this.name = name;
    }

    protected void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException("Portion cannot be less or equal to zero");
        }
        this.portion = portion;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be less or equal to zero!");
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f", name, portion, price);
    }
}
