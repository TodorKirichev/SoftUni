package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.foods.Food;

public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
