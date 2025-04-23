package com.example.ecommerce.migration.core.domain.services;

import com.example.ecommerce.migration.core.domain.entities.Product;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getAvailableProducts();
    Product updateProductStock(Long productId, Integer quantity);
}
