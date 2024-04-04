package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.players;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.models.guns.Gun;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam19December2020.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
