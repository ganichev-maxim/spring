package com.example.spring.boot.tacos.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Taco {

    @Size(min=1, message="You must choose at least 1 ingredient")
    List<String> ingredients;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    String name;

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
