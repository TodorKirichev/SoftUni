package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends BaseRepository<Shampoo> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabel_IdOrderByPrice(Size size, Long label_id);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countAllByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo AS s JOIN s.ingredients AS i WHERE i.name IN :names")
    List<Shampoo> findAllByIngredientsNames(List<String> names);

    @Query("SELECT s FROM Shampoo AS s JOIN s.ingredients AS i GROUP BY s.id HAVING COUNT(i) < :number")
    List<Shampoo> findAllByIngredientsLessThanNumber(int number);
}
