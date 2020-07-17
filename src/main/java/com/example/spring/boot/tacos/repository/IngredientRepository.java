package com.example.spring.boot.tacos.repository;

import com.example.spring.boot.tacos.model.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);
}
