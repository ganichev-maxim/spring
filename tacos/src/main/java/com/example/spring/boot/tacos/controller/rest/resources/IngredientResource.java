package com.example.spring.boot.tacos.controller.rest.resources;

import com.example.spring.boot.tacos.model.Ingredient;
import com.example.spring.boot.tacos.model.Ingredient.Type;
import org.springframework.hateoas.RepresentationModel;

public class IngredientResource extends RepresentationModel<IngredientResource> {

    private String name;
    private Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}
