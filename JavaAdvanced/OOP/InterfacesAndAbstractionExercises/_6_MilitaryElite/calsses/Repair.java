package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces.IRepair;

public class Repair implements IRepair {
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return partName;
    }

    @Override
    public int getHoursWorked() {
        return hoursWorked;
    }
    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d",partName,hoursWorked);
    }
}
