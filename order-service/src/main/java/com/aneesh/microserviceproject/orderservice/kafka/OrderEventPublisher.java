package com.aneesh.microserviceproject.orderservice.kafka;

import com.aneesh.microserviceproject.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventPublisher {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public void sendOrderEvent(Order order) {
        kafkaTemplate.send("order-events", order);
    }
}
