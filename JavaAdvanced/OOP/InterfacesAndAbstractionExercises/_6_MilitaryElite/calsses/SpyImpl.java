package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    String codeNumber;
    public SpyImpl(int id, String firstName, String lastName,String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return codeNumber;
    }
    @Override
    public String toString() {
        return String.format("%s\nCode Number: %s"
        ,super.toString()
        ,codeNumber);
    }
}
