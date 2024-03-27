package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.entities.drinks.interfaces.Beverages;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam15August2021.restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> entities;

    public BeverageRepositoryImpl() {
        entities = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return entities.stream().filter(e -> e.getName().equals(drinkName) && e.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return entities;
    }

    @Override
    public void add(Beverages entity) {
        entities.add(entity);
    }
}
