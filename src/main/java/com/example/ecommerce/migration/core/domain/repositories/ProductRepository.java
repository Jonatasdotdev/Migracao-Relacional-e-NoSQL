package com.example.ecommerce.migration.core.domain.repositories;

import com.example.ecommerce.migration.core.domain.entities.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findAvailableProducts();
    void deleteById(Long id);
}

