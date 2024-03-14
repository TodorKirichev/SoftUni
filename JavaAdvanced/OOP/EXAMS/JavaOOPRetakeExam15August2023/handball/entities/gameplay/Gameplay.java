package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.gameplay;


import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.equipment.Equipment;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.team.Team;

import java.util.Collection;

public interface Gameplay {
    int allProtection();

    void addTeam(Team team);

    void removeTeam(Team team);

    void addEquipment(Equipment equipment);

    void teamsInGameplay();

    Collection<Team> getTeam();

    Collection<Equipment> getEquipments();

    String getName();


}
