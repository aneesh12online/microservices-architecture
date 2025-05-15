package com.aneesh.microserviceproject.productservice.service;

import com.aneesh.microserviceproject.productservice.model.Product;
import com.aneesh.microserviceproject.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public void updateStock(String id, int newStock) {
        Product product = repository.findById(id).orElseThrow();
        product.setStock(newStock);
        repository.save(product);
    }
}
