package com.example.ecommerce.migration.core.infrastructure.postgresql.repositories;


import com.example.ecommerce.migration.core.domain.entities.Vendor;
import com.example.ecommerce.migration.core.domain.repositories.VendorRepository;
import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.VendorEntity;
import com.example.ecommerce.migration.core.infrastructure.postgresql.mappers.VendorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaVendorRepository implements VendorRepository {
    private final SpringDataVendorRepository springDataVendorRepository;
    private final VendorMapper mapper;

    public JpaVendorRepository(SpringDataVendorRepository springDataVendorRepository, VendorMapper mapper) {
        this.springDataVendorRepository = springDataVendorRepository;
        this.mapper = mapper;
    }

    @Override
    public Vendor save(Vendor vendor) {
        VendorEntity entity = mapper.toEntity(vendor);
        VendorEntity savedEntity = springDataVendorRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Vendor> findById(Long id) {
        return springDataVendorRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Vendor> findAll() {
        return springDataVendorRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        springDataVendorRepository.deleteById(id);
    }
}
