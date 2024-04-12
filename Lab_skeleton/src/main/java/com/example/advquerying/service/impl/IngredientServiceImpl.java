package com.example.advquerying.service.impl;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> getAllIngredientsWithStartingName(String symbol) {
        return this.ingredientRepository.findAllByNameStartsWith(symbol)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllIngredientsWithName(List<String> names) {
        List<String> collect = this.ingredientRepository.findAllByNameInOrderByName(names)
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());

        return collect;
    }


}
