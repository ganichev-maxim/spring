package com.example.spring.boot.tacos.controller.rest.resources.assemblers;

import com.example.spring.boot.tacos.controller.rest.IngredientRestController;
import com.example.spring.boot.tacos.controller.rest.resources.IngredientResource;
import com.example.spring.boot.tacos.controller.rest.resources.TacoResource;
import com.example.spring.boot.tacos.model.Ingredient;
import com.example.spring.boot.tacos.model.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class IngredientResourceAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientResource> {

    public IngredientResourceAssembler() {
        super(IngredientRestController.class, IngredientResource.class);
    }

    @Override
    public IngredientResource toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientResource instantiateModel(Ingredient ingredient) {
        return new IngredientResource(ingredient);
    }
}
