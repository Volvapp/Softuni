package com.example.advquerying;

import com.example.advquerying.service.IngredientService;
import com.example.advquerying.service.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public CommandLineRunnerImpl(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //ex1,2,3 this.shampooService.getAllShampoosWithPriceGreaterThan(BigDecimal.valueOf(5))
        //      .forEach(System.out::println);

        //ex 4this.ingredientService.getAllIngredientsWithStartingName("M").forEach(System.out::println);
        // ex5 this.ingredientService.getAllIngredientsWithName(List.of(bf.readLine().split("\\s+"))).forEach(System.out::println);
        //ex 6System.out.println(this.shampooService.countOfIngredientsWithPriceLessThan(BigDecimal.valueOf(8.5)));

        //ex7 this.shampooService.getAllShampoosContainingIngredient(List.of(bf.readLine().split(" "))).forEach(System.out::println);

        //ex8 System.out.println(this.shampooService.countOfIngredientsWithPriceLessThan(BigDecimal.valueOf(5)));
    }
}
