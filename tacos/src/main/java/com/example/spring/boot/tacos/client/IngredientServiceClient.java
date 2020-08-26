package com.example.spring.boot.tacos.client;

import com.example.spring.boot.tacos.model.Ingredient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IngredientServiceClient {
    private RestTemplate rest;
    public IngredientServiceClient(@LoadBalanced RestTemplate rest) {
        this.rest = rest;
    }

    public Ingredient getIngredientById(String ingredientId) {
        return rest.getForObject(
                "http://ingredient-service/ingredients/{id}",
                Ingredient.class, ingredientId);
    }
}
