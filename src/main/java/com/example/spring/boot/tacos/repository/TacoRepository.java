package com.example.spring.boot.tacos.repository;

import com.example.spring.boot.tacos.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository
        extends CrudRepository<Taco, Long> {
}
