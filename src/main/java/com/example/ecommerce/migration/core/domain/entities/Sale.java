package com.example.ecommerce.migration.core.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Sale {
    private Long id;
    private Product product;
    private Vendor vendor;
    private LocalDateTime salesDatetime;
    private Integer quantity;
    private BigDecimal salesAmount;

    public Sale() {
    }

    public Sale(Long id, Product product, Vendor vendor, LocalDateTime salesDatetime, Integer quantity, BigDecimal salesAmount) {
        this.id = id;
        this.product = product;
        this.vendor = vendor;
        this.salesDatetime = salesDatetime;
        this.quantity = quantity;
        this.salesAmount = salesAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public LocalDateTime getSalesDatetime() {
        return salesDatetime;
    }

    public void setSalesDatetime(LocalDateTime salesDatetime) {
        this.salesDatetime = salesDatetime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(BigDecimal salesAmount) {
        this.salesAmount = salesAmount;
    }
}
