package com.aneesh.microserviceproject.productservice.repository;

import com.aneesh.microserviceproject.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
