package com.example.ecommerce.migration.core.infrastructure.postgresql.mappers;

import com.example.ecommerce.migration.core.domain.entities.Sale;
import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.SaleEntity;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper {
    private final ProductMapper productMapper;
    private final VendorMapper vendorMapper;

    public SaleMapper(ProductMapper productMapper, VendorMapper vendorMapper) {
        this.productMapper = productMapper;
        this.vendorMapper = vendorMapper;
    }

    public Sale toDomain(SaleEntity entity) {
        return new Sale(
                entity.getId(),
                productMapper.toDomain(entity.getProduct()),
                vendorMapper.toDomain(entity.getVendor()),
                entity.getSalesDatetime(),
                entity.getQuantity(),
                entity.getSalesAmount()
        );
    }

    public SaleEntity toEntity(Sale domain) {
        return new SaleEntity(
                domain.getId(),
                productMapper.toEntity(domain.getProduct()),
                vendorMapper.toEntity(domain.getVendor()),
                domain.getSalesDatetime(),
                domain.getQuantity(),
                domain.getSalesAmount()
        );
    }
}