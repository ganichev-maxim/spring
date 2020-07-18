package com.example.spring.boot.tacos.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdAt")
    private Date createdAt;

    @Size(min=1, message="You must choose at least 1 ingredient")
    @ManyToMany(targetEntity=Ingredient.class)
    @JoinTable(name = "Taco_Ingredients",
                joinColumns = @JoinColumn(name = "taco" ,referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "ingredient", referencedColumnName = "id"))
    List<Ingredient> ingredients;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    String name;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
