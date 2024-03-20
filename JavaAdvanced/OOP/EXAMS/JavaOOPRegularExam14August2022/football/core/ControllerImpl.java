package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.core;


import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.field.ArtificialTurf;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.field.Field;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.field.NaturalGrass;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.player.Men;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.player.Player;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.player.Women;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.supplement.Liquid;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.supplement.Powdered;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.entities.supplement.Supplement;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.repositories.SupplementRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam14August2022.football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Field> fields;

    public ControllerImpl() {
        supplements = new SupplementRepositoryImpl();
        fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        switch (fieldType) {
            case "ArtificialTurf":
                field = new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field = new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        fields.add(field);
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE,fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement supplement;
        switch (type) {
            case "Powdered":
                supplement = new Powdered();
                break;
            case "Liquid":
                supplement = new Liquid();
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        supplements.add(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE,type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement supplement = supplements.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND,supplementType));
        }
        Field field = findField(fieldName);
        field.getSupplements().add(supplement);
        supplements.remove(supplement);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD,supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player player;
        switch (playerType) {
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        Field field = findField(fieldName);
        boolean canPlay = player.getClass().getSimpleName().equals("Men") && field.getClass().getSimpleName().equals("NaturalGrass")
                || player.getClass().getSimpleName().equals("Women") && field.getClass().getSimpleName().equals("ArtificialTurf");
        if (canPlay) {
            field.addPlayer(player);
            return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType, fieldName);
        } else {
            return String.format(FIELD_NOT_SUITABLE);
        }
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = findField(fieldName);
        field.drag();
        return String.format(PLAYER_DRAG,field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = findField(fieldName);
        int fieldStrength = 0;
        for (Player player : field.getPlayers()) {
            fieldStrength += player.getStrength();
        }
        return String.format(STRENGTH_FIELD,fieldName,fieldStrength);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        fields.forEach(f -> sb.append(f.getInfo()).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    private Field findField(String fieldName) {
        return fields.stream().filter(f -> f.getName().equals(fieldName)).findFirst().get();
    }
}
