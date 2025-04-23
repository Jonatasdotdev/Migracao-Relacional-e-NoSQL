package com.example.ecommerce.migration.core.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String description;
    private BigDecimal price;
    private LocalDate entryDate;
    private Integer stockQuantity;
    private LocalDate expirationDate;
}
