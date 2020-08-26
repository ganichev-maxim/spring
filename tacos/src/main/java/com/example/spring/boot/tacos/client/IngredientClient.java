package com.example.spring.boot.tacos.client;

import com.example.spring.boot.tacos.model.Ingredient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ingredient-service")
public interface IngredientClient {
    @GetMapping("/rest/ingredient/{id}")
    Ingredient getIngredient(@PathVariable("id") String id);
}
