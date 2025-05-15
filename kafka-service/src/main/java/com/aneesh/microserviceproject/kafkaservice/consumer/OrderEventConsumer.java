package com.aneesh.microserviceproject.kafkaservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderEventConsumer.class);

    @KafkaListener(topics = "order-events", groupId = "kafka-service-group")
    public void consume(String event) {
        logger.info("📩 Received order event: {}", event);
        // You can parse JSON, send emails, etc.
    }
}
