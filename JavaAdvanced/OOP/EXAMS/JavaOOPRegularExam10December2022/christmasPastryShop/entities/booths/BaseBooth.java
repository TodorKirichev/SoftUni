package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.booths;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.booths.interfaces.Booth;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
    }

    protected void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
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
        price = numberOfPeople * pricePerPerson;
    }

    @Override
    public double getBill() {
        double bill = 0;
        for (Delicacy delicacyOrder : delicacyOrders) {
            bill += delicacyOrder.getPrice();
        }
        for (Cocktail cocktailOrder : cocktailOrders) {
            bill += cocktailOrder.getPrice();
        }
        bill += price;
        return bill;
    }

    @Override
    public void clear() {
        delicacyOrders.clear();
        cocktailOrders.clear();
        isReserved = false;
        price = 0;
        numberOfPeople = 0;
    }
}
