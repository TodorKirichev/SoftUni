package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends BaseRepository<Ingredient> {

    List<Ingredient> findAllByNameStartingWith(String name);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> names);

    @Modifying
    @Query("DELETE FROM Ingredient i WHERE i.name = :inputName")
    void deleteAllByName(String inputName);

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1")
    @Modifying
    void updateIngredientsPrice();
}
