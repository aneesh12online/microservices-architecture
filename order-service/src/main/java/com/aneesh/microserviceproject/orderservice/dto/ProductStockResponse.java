package com.aneesh.microserviceproject.orderservice.dto;

import lombok.Data;

@Data
public class ProductStockResponse {
    private String id;
    private String name;
    private int stock;
}
