package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.booths;

public class PrivateBooth extends BaseBooth {
    private static final double pricePerPerson = 3.50;
    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, pricePerPerson);
    }
}
