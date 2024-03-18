package SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories;

import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import SoftUni.JavaAdvanced.OOP.EXAMS.JavaOOPRegularExam10December2022.christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.ArrayList;
import java.util.Collection;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {
    private Collection<Cocktail> cocktails;

    public CocktailRepositoryImpl() {
        cocktails = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return cocktails.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return cocktails;
    }

    @Override
    public void add(Cocktail cocktail) {
        cocktails.add(cocktail);
    }
}
