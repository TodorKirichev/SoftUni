package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

public interface IngredientService {
    List<Ingredient> findAllByNameStartingWith(String name);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> names);

    void deleteAllByName(String name);

    void updateIngredientsPrice();

}
