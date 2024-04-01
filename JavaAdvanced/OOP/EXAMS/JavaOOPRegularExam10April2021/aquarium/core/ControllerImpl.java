package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.aquariums.Aquarium;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.aquariums.FreshwaterAquarium;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.aquariums.SaltwaterAquarium;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.decorations.Decoration;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.decorations.Ornament;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.decorations.Plant;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.fish.Fish;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.fish.FreshwaterFish;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.entities.fish.SaltwaterFish;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10April2021.aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        decorationRepository = new DecorationRepository();
        aquariums = new ArrayList<>();
    }

    private Aquarium findAquarium(String aquariumName) {
        return aquariums.stream().filter(a -> a.getName().equals(aquariumName)).findFirst().orElse(null);
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        decorationRepository.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorationRepository.findByType(decorationType);
        if (decoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        Aquarium aquarium = findAquarium(aquariumName);
        aquarium.addDecoration(decoration);
        decorationRepository.remove(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        Aquarium aquarium = findAquarium(aquariumName);
        boolean isSuitable = aquarium.getClass().getSimpleName().equals("SaltwaterAquarium") && fishType.equals("SaltwaterFish")
                || aquarium.getClass().getSimpleName().equals("FreshwaterAquarium") && fishType.equals("FreshwaterFish");
        if (isSuitable) {
            try {
            aquarium.addFish(fish);
            return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        } else {
            return String.format(WATER_NOT_SUITABLE);
        }
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = findAquarium(aquariumName);
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = findAquarium(aquariumName);
        double aquariumValue = 0;
        for (Fish fish : aquarium.getFish()) {
            aquariumValue += fish.getPrice();
        }
        for (Decoration decoration : aquarium.getDecorations()) {
            aquariumValue += decoration.getPrice();
        }
        return String.format(VALUE_AQUARIUM, aquariumName, aquariumValue);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        aquariums.forEach(a -> sb.append(a.getInfo()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
