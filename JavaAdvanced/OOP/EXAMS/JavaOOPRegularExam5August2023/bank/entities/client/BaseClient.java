package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.entities.client;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam5August2023.bank.common.ExceptionMessages.*;

public abstract class BaseClient implements Client{
    private String name;
    private String ID;
    private int interest;
    private double income;

    public BaseClient(String name, String ID, int interest, double income) {
        setName(name);
        setID(ID);
        setInterest(interest);
        setIncome(income);
    }

    public String getID() {
        return ID;
    }

    protected void setID(String ID) {
        if (ID == null || ID.trim().isEmpty()) {
            throw new IllegalArgumentException(CLIENT_ID_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.ID = ID;
    }

    protected void setInterest(int interest) {
        this.interest = interest;
    }

    protected void setIncome(double income) {
        if (income <= 0) {
            throw new IllegalArgumentException(CLIENT_INCOME_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.income = income;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(CLIENT_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getInterest() {
        return interest;
    }

    @Override
    public double getIncome() {
        return income;
    }

    @Override
    public abstract void increase();
}
