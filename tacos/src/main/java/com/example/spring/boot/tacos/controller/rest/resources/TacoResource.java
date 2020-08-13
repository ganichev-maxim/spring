package com.example.spring.boot.tacos.controller.rest.resources;

import com.example.spring.boot.tacos.controller.rest.resources.assemblers.IngredientResourceAssembler;
import com.example.spring.boot.tacos.model.Taco;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;

@Relation(value="taco", collectionRelation="tacos")
public class TacoResource extends RepresentationModel<TacoResource> {
    private static final IngredientResourceAssembler
            ingredientAssembler = new IngredientResourceAssembler();
    private final String name;
    private final Date createdAt;
    private final CollectionModel<IngredientResource> ingredients;
    public TacoResource(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toCollectionModel(taco.getIngredients());
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public CollectionModel<IngredientResource> getIngredients() {
        return ingredients;
    }
}
