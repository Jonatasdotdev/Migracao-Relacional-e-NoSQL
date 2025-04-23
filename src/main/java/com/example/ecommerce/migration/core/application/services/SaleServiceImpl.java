package com.example.ecommerce.migration.core.application.services;

import com.example.ecommerce.migration.core.domain.entities.Product;
import com.example.ecommerce.migration.core.domain.entities.Sale;
import com.example.ecommerce.migration.core.domain.entities.Vendor;
import com.example.ecommerce.migration.core.domain.repositories.ProductRepository;
import com.example.ecommerce.migration.core.domain.repositories.SaleRepository;
import com.example.ecommerce.migration.core.domain.repositories.VendorRepository;
import com.example.ecommerce.migration.core.domain.services.SaleService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final VendorRepository vendorRepository;

    public SaleServiceImpl(SaleRepository saleRepository, ProductRepository productRepository, VendorRepository vendorRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Sale processSale(Sale sale) {
        // Verificar se o produto existe
        Product product = productRepository.findById(sale.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        // Verificar se o vendedor existe
        Vendor vendor = vendorRepository.findById(sale.getVendor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vendedor não encontrado"));

        // Verificar estoque disponível
        if (product.getStockQuantity() <= 0) {
            throw new IllegalStateException("Produto sem estoque disponível");
        }

        // Verificar validade (não vender produtos que vencem nos próximos 20 dias)
        if (product.getExpirationDate().isBefore(LocalDate.now().plusDays(20))) {
            throw new IllegalStateException("Produto com validade próxima (menos de 20 dias)");
        }

        // Verificar quantidade solicitada
        if (sale.getQuantity() > product.getStockQuantity()) {
            throw new IllegalStateException("Quantidade solicitada maior que o estoque disponível");
        }

        // Calcular valor total
        BigDecimal totalAmount = product.getPrice().multiply(BigDecimal.valueOf(sale.getQuantity()));
        sale.setSalesAmount(totalAmount);

        // Atualizar estoque
        product.setStockQuantity(product.getStockQuantity() - sale.getQuantity());
        productRepository.save(product);

        // Definir data/hora atual
        sale.setSalesDatetime(LocalDateTime.now());

        // Salvar venda
        return saleRepository.save(sale);
    }
    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public List<Sale> generateSalesReport() {
        return saleRepository.generateSalesReport();
    }
}

