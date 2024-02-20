package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.calsses;

import SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionExercises._6_MilitaryElite.interfaces.Engineer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;
    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(repairs);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());
        repairs.forEach(r -> sb.append(r.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
