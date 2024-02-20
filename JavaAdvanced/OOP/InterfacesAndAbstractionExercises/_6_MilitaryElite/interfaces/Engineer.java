package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses.Repair;

import java.util.List;

public interface Engineer extends SpecialisedSoldier{
    void addRepair(Repair repair);
    List<Repair> getRepairs();
}
