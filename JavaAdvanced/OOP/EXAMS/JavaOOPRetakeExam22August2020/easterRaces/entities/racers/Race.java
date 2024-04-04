package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.entities.racers;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam22August2020.easterRaces.entities.drivers.Driver;

import java.util.Collection;

public interface Race {
    String getName();

    int getLaps();

    Collection<Driver> getDrivers();

    void addDriver(Driver driver);
}
