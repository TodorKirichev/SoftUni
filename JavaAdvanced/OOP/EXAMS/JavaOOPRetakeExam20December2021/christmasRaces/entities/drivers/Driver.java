package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.drivers;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam20December2021.christmasRaces.entities.cars.Car;

public interface Driver {
    String getName();

    Car getCar();

    int getNumberOfWins();

    void addCar(Car car);

    void winRace();

    boolean getCanParticipate();
}
