package com.example.spring.boot.tacos.model.converter;

import com.example.spring.boot.tacos.model.Ingredient;
import com.example.spring.boot.tacos.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TacoConverter implements Converter<String, Ingredient> {
    @Autowired
    IngredientRepository ingredientRepository;
    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findOne(id);
    }
}
