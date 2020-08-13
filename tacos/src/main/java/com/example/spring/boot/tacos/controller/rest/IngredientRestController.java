package com.example.spring.boot.tacos.controller.rest;


import com.example.spring.boot.tacos.model.Ingredient;
import com.example.spring.boot.tacos.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/rest/ingredient",
        produces="application/json")
@CrossOrigin(origins="*")
public class IngredientRestController {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientRestController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> tacoById(@PathVariable("id") String id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if (ingredient.isPresent()) {
            return new ResponseEntity<>(ingredient.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
