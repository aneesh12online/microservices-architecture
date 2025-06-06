package com.aneesh.microserviceproject.orderservice.repository;

import com.aneesh.microserviceproject.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);
}
