package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.tables;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.bakedFoods.interfaces.BakedFood;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.drinks.interfaces.Drink;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        setTableNumber(tableNumber);
        setCapacity(capacity);
        setPricePerPerson(pricePerPerson);
        foodOrders = new ArrayList<>();
        drinkOrders = new ArrayList<>();
        isReserved = false;
        price = 0;
    }

    protected void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    protected void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity has to be greater than 0");
        }
        this.capacity = capacity;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException("Cannot place zero or less people!");
        }
        this.numberOfPeople = numberOfPeople;
    }

    protected void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill = 0;
        for (BakedFood food : foodOrders) {
            bill += food.getPrice();
        }
        for (Drink drink : drinkOrders) {
            bill += drink.getPrice();
        }
        price = numberOfPeople * pricePerPerson;
        bill += price;
        return bill;
    }

    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        numberOfPeople = 0;
        isReserved = false;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d", tableNumber)).append(System.lineSeparator());
        sb.append(String.format("Type: %s", getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Capacity: %d", capacity)).append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f", pricePerPerson));
        return sb.toString().trim();
    }
}
