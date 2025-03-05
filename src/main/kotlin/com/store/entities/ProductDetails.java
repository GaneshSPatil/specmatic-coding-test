package com.store.entities;

import com.store.annotations.TextOnly;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductDetails {
    @NotNull
    @TextOnly
    private String name;

    @NotNull
    private ProductType type;

    @Min(1)
    @Max(9999)
    private int inventory;
}
