package com.example.ecommerce.migration.core.infrastructure.postgresql.repositories;



import com.example.ecommerce.migration.core.domain.entities.Sale;
import com.example.ecommerce.migration.core.domain.repositories.SaleRepository;
import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.SaleEntity;
import com.example.ecommerce.migration.core.infrastructure.postgresql.mappers.SaleMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JpaSaleRepository implements SaleRepository {
    private final SpringDataSaleRepository springDataSaleRepository;
    private final SaleMapper mapper;

    public JpaSaleRepository(SpringDataSaleRepository springDataSaleRepository, SaleMapper mapper) {
        this.springDataSaleRepository = springDataSaleRepository;
        this.mapper = mapper;
    }

    @Override
    public Sale save(Sale sale) {
        SaleEntity entity = mapper.toEntity(sale);
        SaleEntity savedEntity = springDataSaleRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<Sale> findAll() {
        return springDataSaleRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Sale> generateSalesReport() {
        // Implementação específica para o relatório
        return findAll();
    }
}