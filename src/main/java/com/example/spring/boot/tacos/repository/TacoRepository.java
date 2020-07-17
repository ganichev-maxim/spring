package com.example.spring.boot.tacos.repository;

import com.example.spring.boot.tacos.model.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
