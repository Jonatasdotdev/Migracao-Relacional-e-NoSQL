package com.example.ecommerce.migration.core.domain.services;

import com.example.ecommerce.migration.core.domain.entities.Sale;
import java.util.List;

public interface SaleService {
    Sale processSale(Sale sale);
    List<Sale> getAllSales();
    List<Sale> generateSalesReport();
}
