package com.example.ecommerce.migration.core.infrastructure.postgresql.repositories;



import com.example.ecommerce.migration.core.domain.entities.Product;
import com.example.ecommerce.migration.core.domain.repositories.ProductRepository;
import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.ProductEntity;
import com.example.ecommerce.migration.core.infrastructure.postgresql.mappers.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class JpaProductRepository implements ProductRepository {
    private final SpringDataProductRepository springDataProductRepository;
    private final ProductMapper mapper;

    public JpaProductRepository(SpringDataProductRepository springDataProductRepository, ProductMapper mapper) {
        this.springDataProductRepository = springDataProductRepository;
        this.mapper = mapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapper.toEntity(product);
        ProductEntity savedEntity = springDataProductRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return springDataProductRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return springDataProductRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAvailableProducts() {
        return springDataProductRepository.findByStockQuantityGreaterThan(0).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        springDataProductRepository.deleteById(id);
    }
}