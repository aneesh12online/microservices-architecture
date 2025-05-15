package com.aneesh.microserviceproject.orderservice.controller;

import com.aneesh.microserviceproject.orderservice.model.Order;
import com.aneesh.microserviceproject.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping
    public List<Order> all() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getById(@PathVariable String orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getByUser(@PathVariable String userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PutMapping("/{orderId}/cancel")
    public Order cancel(@PathVariable String orderId) {
        return orderService.cancelOrder(orderId);
    }
}
