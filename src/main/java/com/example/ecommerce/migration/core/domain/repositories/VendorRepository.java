package com.example.ecommerce.migration.core.domain.repositories;

import com.example.ecommerce.migration.core.domain.entities.Vendor;
import java.util.List;
import java.util.Optional;

public interface VendorRepository {
    Vendor save(Vendor vendor);
    Optional<Vendor> findById(Long id);
    List<Vendor> findAll();
    void deleteById(Long id);
}