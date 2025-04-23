package com.example.ecommerce.migration.core.infrastructure.mongodb.repositories;

import com.example.ecommerce.migration.core.infrastructure.mongodb.entities.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoProductRepository extends MongoRepository<ProductDocument, String> {
}
