package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam11December2021.catHouse.entities.houses;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam11December2021.catHouse.entities.cat.Cat;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam11December2021.catHouse.entities.toys.Toy;

import java.util.Collection;

public interface House {
    int sumSoftness();

    void addCat(Cat cat);

    void removeCat(Cat cat);

    void buyToy(Toy toy);

    void feeding();

    String getStatistics();

    String getName();

    void setName(String name);

    Collection<Cat> getCats();

    Collection<Toy> getToys();
}
