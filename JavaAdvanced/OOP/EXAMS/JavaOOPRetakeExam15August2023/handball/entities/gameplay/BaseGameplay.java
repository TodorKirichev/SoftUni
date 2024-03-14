package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.gameplay;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.equipment.Equipment;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;

public abstract class BaseGameplay implements Gameplay {
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    protected BaseGameplay(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        equipments = new ArrayList<>();
        teams = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int allProtection() {
        return equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return equipments;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s",getName(),getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        if (teams.isEmpty()) {
            sb.append("Team: none");

        } else {
            sb.append(String.format("Team: %s",teams.stream().map(Team::getName).collect(Collectors.joining(" "))));
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Equipment: %d, Protection: %d",equipments.size(),equipments
                .stream().mapToInt(Equipment::getProtection).sum()));
        return sb.toString().trim();
    }
}
