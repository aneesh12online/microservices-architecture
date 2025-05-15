package com.aneesh.microserviceproject.orderservice.feign;

import com.aneesh.microserviceproject.orderservice.dto.ProductStockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {
    @GetMapping("/products/{id}")
    ProductStockResponse getProductById(@PathVariable("id") String productId);
}
