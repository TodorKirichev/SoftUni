package SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.cat.Cat;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.cat.LonghairCat;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.cat.ShorthairCat;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.houses.House;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.houses.LongHouse;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.houses.ShortHouse;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.toys.Ball;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.toys.Mouse;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.entities.toys.Toy;
import SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.common.ConstantMessages.*;
import static SoftUni.JavaAdvanced.OOP.EXAMS.OOPRegularExam11December2021.catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new ArrayList<>();
    }

    private House findHouse(String houseName) {
        return houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE,type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE,type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND,toyType));
        }
        House house = findHouse(houseName);
        house.buyToy(toy);
        toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE,toyType,houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house = findHouse(houseName);
        boolean isSuitable = cat.getClass().getSimpleName().equals("ShorthairCat") && house.getClass().getSimpleName().equals("ShortHouse")
                || cat.getClass().getSimpleName().equals("LonghairCat") && house.getClass().getSimpleName().equals("LongHouse");
        if (isSuitable) {
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else {
            return UNSUITABLE_HOUSE;
        }
    }

    @Override
    public String feedingCat(String houseName) {
        House house = findHouse(houseName);
        house.feeding();
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = findHouse(houseName);
        double sum = 0;
        for (Cat cat : house.getCats()) {
            sum += cat.getPrice();
        }
        for (Toy toy : house.getToys()) {
            sum += toy.getPrice();
        }
        return String.format(VALUE_HOUSE, houseName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        houses.forEach(h -> sb.append(h.getStatistics()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
