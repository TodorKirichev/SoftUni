package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.booths.interfaces;

public interface Booth {
    int getBoothNumber();

    int getCapacity();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    double getBill();

    void clear();
}
