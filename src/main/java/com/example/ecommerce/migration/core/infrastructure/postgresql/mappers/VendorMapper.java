package com.example.ecommerce.migration.core.infrastructure.postgresql.mappers;


import com.example.ecommerce.migration.core.domain.entities.Vendor;
import com.example.ecommerce.migration.core.infrastructure.postgresql.entities.VendorEntity;
import org.springframework.stereotype.Component;

@Component
public class VendorMapper {
    public Vendor toDomain(VendorEntity entity) {
        return new Vendor(entity.getId(), entity.getName());
    }

    public VendorEntity toEntity(Vendor domain) {
        return new VendorEntity(domain.getId(), domain.getName());
    }
}
