package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.drinks;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.drinks.interfaces.Drink;

public abstract class BaseDrink implements Drink {
    private String name;
    private int portion;
    private double price;
    private String brand;

    public BaseDrink(String name, int portion, double price, String brand) {
        setName(name);
        setPortion(portion);
        setPrice(price);
        setBrand(brand);
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or white space!");
        }
        this.name = name;
    }

    protected void setPortion(int portion) {
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

    protected void setBrand(String brand) {
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or white space!");
        }
        this.brand = brand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("%s %s - %dml - %.2flv", name, brand, portion, price);
    }
}
