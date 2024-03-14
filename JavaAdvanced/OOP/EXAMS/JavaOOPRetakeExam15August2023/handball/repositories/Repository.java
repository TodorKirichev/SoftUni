package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.repositories;


import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.equipment.Equipment;

public interface Repository {
    void add(Equipment equipment);
    boolean remove(Equipment equipment);
    Equipment findByType(String type);
}
