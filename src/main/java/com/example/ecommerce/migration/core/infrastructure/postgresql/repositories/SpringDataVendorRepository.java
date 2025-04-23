package com.example.ecommerce.migration.core.infrastructure.postgresql.repositories;



import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataVendorRepository extends JpaRepository<VendorEntity, Long> {
}
