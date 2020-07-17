package com.example.spring.boot.tacos.repository;

import com.example.spring.boot.tacos.model.Order;

public interface OrderRepository {
    Order save(Order order);
}
