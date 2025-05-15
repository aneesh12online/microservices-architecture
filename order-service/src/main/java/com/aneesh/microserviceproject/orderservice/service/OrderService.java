package com.aneesh.microserviceproject.orderservice.service;

import com.aneesh.microserviceproject.orderservice.feign.ProductClient;
import com.aneesh.microserviceproject.orderservice.kafka.OrderEventPublisher;
import com.aneesh.microserviceproject.orderservice.model.Order;
import com.aneesh.microserviceproject.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final OrderEventPublisher publisher;

    public Order placeOrder(Order order) {
        var stockResponse = productClient.getProductById(order.getProductId());
        if (stockResponse.getStock() < order.getQuantity()) {
            throw new RuntimeException("Insufficient stock for product: " + order.getProductId());
        }
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CREATED");

        Order saved = orderRepository.save(order);

        // Send event to Kafka
        publisher.sendOrderEvent(saved);

        return saved;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUser(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order cancelOrder(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus("CANCELLED");
        return orderRepository.save(order);
    }

    public Order getOrder(String orderId) {
        return orderRepository.findById(orderId).orElseThrow();
    }
}
