package com.example.spring.boot.tacos.repository;

import com.example.spring.boot.tacos.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}
