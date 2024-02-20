package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses.Mission;

import java.util.List;

public interface Commando {
    void addMission(Mission mission);
    List<Mission> getMissions();
}
