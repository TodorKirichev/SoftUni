package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces.Soldier;

public class SoldierImpl implements Soldier {
    private int id;
    private String firstName;
    private String lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s", firstName, lastName, id);
    }
}
