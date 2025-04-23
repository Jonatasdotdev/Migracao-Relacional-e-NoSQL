package com.example.ecommerce.migration.core.infrastructure.postgresql.mappers;

import com.example.ecommerce.migration.core.domain.entities.Product;
import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toDomain(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getEntryDate(),
                entity.getStockQuantity(),
                entity.getExpirationDate()
        );
    }

    public ProductEntity toEntity(Product domain) {
        return new ProductEntity(
                domain.getId(),
                domain.getDescription(),
                domain.getPrice(),
                domain.getEntryDate(),
                domain.getStockQuantity(),
                domain.getExpirationDate()
        );
    }
}
