package com.example.advquerying.repositories;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findAllByBrandAndSize(String brand, Size size);

    List<Shampoo> findBySizeOrderById(Size size);

    @Query("select s from Shampoo as s join s.ingredients as i where i.name in :ingredientsName")
    List<Shampoo> findByIngredientsNames(@Param("ingredientsName") Set<String> ingredients);
    // @Param се използва ако името на параметъра в заявката(ingredientsName) се различава от името на параметъра в метода(ingredients) !
}
