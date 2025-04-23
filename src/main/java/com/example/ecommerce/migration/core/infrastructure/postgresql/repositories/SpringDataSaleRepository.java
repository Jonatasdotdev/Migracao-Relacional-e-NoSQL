package com.example.ecommerce.migration.core.infrastructure.postgresql.repositories;



import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataSaleRepository extends JpaRepository<SaleEntity, Long> {
}
