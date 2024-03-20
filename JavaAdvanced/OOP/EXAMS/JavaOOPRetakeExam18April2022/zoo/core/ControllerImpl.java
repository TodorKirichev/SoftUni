package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.animals.Animal;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.animals.AquaticAnimal;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.animals.TerrestrialAnimal;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.areas.Area;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.areas.LandArea;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.areas.WaterArea;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.foods.Food;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.foods.Meat;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.entities.foods.Vegetable;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.repositories.FoodRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRetakeExam18April2022.zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        foodRepository = new FoodRepositoryImpl();
        areas = new ArrayList<>();
    }

    private Area findArea(String areaName) {
        return areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().get();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        switch (areaType) {
            case "WaterArea":area = new WaterArea(areaName);
                break;
            case "LandArea":
                area = new LandArea(areaName);
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }
        areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE,areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        switch (foodType) {
            case "Vegetable":
                food = new Vegetable();
                break;
            case "Meat":
                food = new Meat();
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE,foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND,foodType));
        }
        Area area = findArea(areaName);
        area.addFood(food);
        foodRepository.remove(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA,foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName,kind,price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName,kind,price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        Area area = findArea(areaName);
        boolean canLive = animal.getClass().getSimpleName().equals("AquaticAnimal") && area.getClass().getSimpleName().equals("WaterArea")
                || animal.getClass().getSimpleName().equals("TerrestrialAnimal") && area.getClass().getSimpleName().equals("LandArea");
        if (canLive) {
            try {
                area.addAnimal(animal);
                return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA,animalType,areaName);
            } catch (IllegalStateException e) {
                return e.getMessage();
            }
        } else {
            return AREA_NOT_SUITABLE;
        }
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = findArea(areaName);
        area.feed();
        return String.format(ANIMALS_FED,area.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = findArea(areaName);
        double areaCalculatedKg = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
        return String.format(KILOGRAMS_AREA,areaName,areaCalculatedKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        areas.forEach(a -> sb.append(a.getInfo()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
