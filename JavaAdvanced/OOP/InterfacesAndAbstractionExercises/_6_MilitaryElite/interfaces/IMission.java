package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.enums.State;

public interface IMission {
    String getCodeName();
    State getState();
    void completeMission();
}
