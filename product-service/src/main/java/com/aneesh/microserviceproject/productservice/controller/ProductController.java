package com.aneesh.microserviceproject.productservice.controller;

import com.aneesh.microserviceproject.productservice.model.Product;
import com.aneesh.microserviceproject.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> all() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}/stock")
    public void updateStock(@PathVariable String id, @RequestParam int stock) {
        productService.updateStock(id, stock);
    }
}
