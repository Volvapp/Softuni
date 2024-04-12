package com.example.advquerying.service;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientService {
    List<String> getAllIngredientsWithStartingName(String symbol);

    List<String> getAllIngredientsWithName(List<String> names);
}
