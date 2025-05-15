package com.aneesh.microserviceproject.orderservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    private String id;
    private String userId;
    private String productId;
    private int quantity;
    private LocalDateTime orderDate;
    private String status;
}
