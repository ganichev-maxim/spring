package com.example.spring.boot.tacos.repository;

import com.example.spring.boot.tacos.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository
        extends CrudRepository<Order, Long> {
    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

}
