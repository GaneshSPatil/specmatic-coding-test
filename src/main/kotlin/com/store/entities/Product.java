package com.store.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Product extends ProductDetails {
    private int id;

    public static Product from(int id, ProductDetails details) {
        return Product.builder()
                .id(id)
                .name(details.getName())
                .type(details.getType())
                .inventory(details.getInventory())
                .cost(details.getCost())
                .build();
    }
}
