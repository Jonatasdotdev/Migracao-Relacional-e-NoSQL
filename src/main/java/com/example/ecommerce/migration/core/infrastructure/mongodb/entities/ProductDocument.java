package com.example.ecommerce.migration.core.infrastructure.mongodb.entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDocument {
    @Id
    private String id;
    private String description;
    private BigDecimal price;
    private LocalDate entryDate;
    private Integer stockQuantity;
    private LocalDate expirationDate;
}