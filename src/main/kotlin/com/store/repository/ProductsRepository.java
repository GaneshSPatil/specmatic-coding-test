package com.store.repository;

import com.store.entities.Product;
import com.store.entities.ProductDetails;
import com.store.entities.ProductId;
import com.store.entities.ProductType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ProductsRepository {
    private final List<Product> products = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> findByType(ProductType type) {
        return products.stream()
                .filter(product -> product.getType().equals(type))
                .collect(Collectors.toList());
    }

    public ProductId addProduct(ProductDetails productDetails) {
        int id = idCounter.getAndIncrement();

        Product product = Product.from(id, productDetails);
        products.add(product);

        return new ProductId(id);
    }
}
