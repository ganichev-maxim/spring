package com.example.spring.boot.tacos.repository;

import com.example.spring.boot.tacos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
