package com.example.ecommerce.migration.core.application.services;

import com.example.ecommerce.migration.core.domain.entities.Product;
import com.example.ecommerce.migration.core.domain.repositories.ProductRepository;
import com.example.ecommerce.migration.core.infrastructure.mongodb.entities.ProductDocument;
import com.example.ecommerce.migration.core.infrastructure.mongodb.repositories.MongoProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MigrationService {
    private final ProductRepository productRepository;
    private final MongoProductRepository mongoProductRepository;

    public MigrationService(ProductRepository productRepository, MongoProductRepository mongoProductRepository) {
        this.productRepository = productRepository;
        this.mongoProductRepository = mongoProductRepository;
    }

    public void migrateProductsToMongoDB() {
        List<Product> products = productRepository.findAll();

        List<ProductDocument> documents = products.stream()
                .map(this::convertToDocument)
                .collect(Collectors.toList());

        mongoProductRepository.saveAll(documents);
    }

    private ProductDocument convertToDocument(Product product) {
        return new ProductDocument(
                product.getId().toString(),
                product.getDescription(),
                product.getPrice(),
                product.getEntryDate(),
                product.getStockQuantity(),
                product.getExpirationDate()
        );
    }
}