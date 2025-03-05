package com.store.controllers;

import com.store.entities.Product;
import com.store.entities.ProductDetails;
import com.store.entities.ProductId;
import com.store.entities.ProductType;
import com.store.repository.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsRepository repository;

    @Autowired
    public ProductsController(ProductsRepository productsRepository) {
        repository = productsRepository;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam(name = "type", required = false) ProductType type) {
        if (type == null) {
            return ResponseEntity.ok(repository.getAllProducts());
        }
        return ResponseEntity.ok(repository.findByType(type));
    }

    @PostMapping
    public ResponseEntity<ProductId> createProduct(@Valid @RequestBody ProductDetails productDetails) {
        ProductId productId = repository.addProduct(productDetails);
        return ResponseEntity.status(201).body(productId);
    }
}
