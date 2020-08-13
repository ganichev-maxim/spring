package com.example.spring.boot.tacos.integration.model;

import com.example.spring.boot.tacos.model.Taco;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String email;
    private List<Taco> tacos = new ArrayList<>();

    public Order(String email) {
        this.email = email;
    }
    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }

    public String getEmail() {
        return email;
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    public void setTacos(List<Taco> tacos) {
        this.tacos = tacos;
    }
}
