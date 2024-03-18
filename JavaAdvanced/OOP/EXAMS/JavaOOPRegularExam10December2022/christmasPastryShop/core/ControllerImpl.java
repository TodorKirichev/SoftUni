package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.core;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.core.interfaces.Controller;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.booths.OpenBooth;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.booths.PrivateBooth;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.cocktails.Hibernation;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.cocktails.MulledWine;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.delicacies.Gingerbread;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.delicacies.Stolen;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.booths.interfaces.Booth;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories.interfaces.BoothRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories.interfaces.CocktailRepository;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories.interfaces.DelicacyRepository;

import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;


    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome = 0;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = null;
        switch (type) {
            case "Gingerbread":
                delicacy = new Gingerbread(name, price);
                break;
            case"Stolen":
                delicacy = new Stolen(name, price);
                break;
        }
        if (delicacyRepository.getAll().contains(delicacy)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type, name));
        }
        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED,name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = null;
        switch (type) {
            case "Hibernation":
                cocktail = new Hibernation(name, size, brand);
                break;
            case "MulledWine":
                cocktail = new MulledWine(name, size, brand);
                break;
        }
        if (cocktailRepository.getAll().contains(cocktail)) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }
        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED,name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = null;
        switch (type) {
            case "OpenBooth":
                booth = new OpenBooth(boothNumber, capacity);
                break;
            case "PrivateBooth":
                booth = new PrivateBooth(boothNumber, capacity);
                break;
        }
        if (boothRepository.getAll().contains(booth)) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST,boothNumber));
        }
        boothRepository.add(booth);
        return String.format(BOOTH_ADDED,boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth booth = boothRepository.getAll().stream()
                .filter(b -> !b.isReserved())
                .filter(b -> b.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);
        if (booth == null) {
            return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
        } else {
            booth.reserve(numberOfPeople);
            return String.format(BOOTH_RESERVED,booth.getBoothNumber(),numberOfPeople);
        }
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        booth.clear();
        totalIncome += bill;
        return String.format(BILL,boothNumber,bill);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME,totalIncome);
    }
}
