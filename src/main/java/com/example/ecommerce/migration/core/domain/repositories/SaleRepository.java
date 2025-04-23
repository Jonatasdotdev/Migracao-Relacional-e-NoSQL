package com.example.ecommerce.migration.core.domain.repositories;

import com.example.ecommerce.migration.core.domain.entities.Sale;
import java.util.List;

public interface SaleRepository {
    Sale save(Sale sale);
    List<Sale> findAll();
    List<Sale> generateSalesReport();
}
