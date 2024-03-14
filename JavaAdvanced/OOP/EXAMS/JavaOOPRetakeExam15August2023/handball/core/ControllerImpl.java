package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.equipment.ElbowPad;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.equipment.Equipment;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.equipment.Kneepad;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.gameplay.Gameplay;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.gameplay.Indoor;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.gameplay.Outdoor;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.team.Bulgaria;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.team.Germany;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.entities.team.Team;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.repositories.EquipmentRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam15August2023.handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository equipment ;
    private Collection<Gameplay> gameplays ;

    public ControllerImpl() {
        equipment = new EquipmentRepository();
        gameplays = new ArrayList<>();
    }

    private Gameplay findGameplay(String gameplayName) {
        return gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findFirst().get();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        switch (gameplayType) {
            case "Outdoor":
                gameplay = new Outdoor(gameplayName);
                break;
            case "Indoor":
                gameplay = new Indoor(gameplayName);
                break;
            default:
                throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }
        gameplays.add(gameplay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE,gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment currentEquipment1;
        switch (equipmentType) {
            case "Kneepad":
                currentEquipment1 = new Kneepad();
                break;
            case "ElbowPad":
                currentEquipment1 = new ElbowPad();
                break;
            default:
                throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }
        equipment.add(currentEquipment1);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE,equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment currentEquipment = equipment.findByType(equipmentType);
        if (currentEquipment == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND,equipmentType));
        }
        Gameplay currentGameplay = findGameplay(gameplayName);
        currentGameplay.addEquipment(currentEquipment);
        equipment.remove(currentEquipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY,equipmentType,gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Gameplay gameplay = findGameplay(gameplayName);
        Team team;
        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default:
                throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }
        boolean canPlay = teamType.equals("Bulgaria") && gameplay.getClass().getSimpleName().equals("Outdoor") ||
                teamType.equals("Germany") && gameplay.getClass().getSimpleName().equals("Indoor");
        if (canPlay) {
            gameplay.addTeam(team);
            return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY,teamType,gameplayName);
        } else {
            return GAMEPLAY_NOT_SUITABLE;
        }
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = findGameplay(gameplayName);
        gameplay.getTeam().forEach(Team::play);
        int countTeamsPlayed = gameplay.getTeam().size();
        return String.format(TEAMS_PLAYED,countTeamsPlayed);
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = findGameplay(gameplayName);
        int advantage = 0;
        for (Team team : gameplay.getTeam()) {
            advantage += team.getAdvantage();
        }
        return String.format(ADVANTAGE_GAMEPLAY,gameplayName, advantage);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        gameplays.forEach(g -> sb.append(g).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
