package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Set<Ingredient> findAllByNameStartsWith(String symbol);

    Set<Ingredient> findAllByNameInOrderByName(List<String> names);

}
