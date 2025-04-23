package com.example.ecommerce.migration.core.infrastructure.postgresql.repositories;



import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByStockQuantityGreaterThan(Integer quantity);
}
