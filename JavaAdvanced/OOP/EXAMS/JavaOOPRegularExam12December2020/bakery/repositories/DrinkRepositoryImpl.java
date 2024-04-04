package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.entities.drinks.interfaces.Drink;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam12December2020.bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        return models.stream().filter(d -> d.getName().equals(drinkName) && d.getBrand().equals(drinkBrand)).findFirst().orElse(null);
    }

    @Override
    public Collection<Drink> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Drink drink) {
        models.add(drink);
    }
}
