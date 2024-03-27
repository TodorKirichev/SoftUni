package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.tables;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.drinks.interfaces.Beverages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.common.ExceptionMessages.INVALID_TABLE_SIZE;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        setSize(size);
        this.pricePerPerson = pricePerPerson;
        healthyFood = new ArrayList<>();
        beverages = new ArrayList<>();
        isReservedTable = false;
        allPeople = 0;
    }

    protected void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        healthyFood.add(food);
        allPeople += food.getPrice();
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
        allPeople += beverages.getPrice();
    }

    @Override
    public double bill() {
        double bill = 0;
        for (HealthyFood food : healthyFood) {
            bill += food.getPrice();
        }
        for (Beverages beverage : beverages) {
            bill += beverage.getPrice();
        }
        return bill * numberOfPeople;
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        isReservedTable = false;
        numberOfPeople = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table - %d",number)).append(System.lineSeparator());
        sb.append(String.format("Size - %d",size)).append(System.lineSeparator());
        sb.append(String.format("Type - %s",getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("All price - %f",bill() / numberOfPeople)).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
