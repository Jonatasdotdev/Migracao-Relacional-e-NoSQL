package com.example.ecommerce.migration.core.infrastructure.postgresql.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private VendorEntity vendor;

    @Column(name = "sales_datetime", nullable = false)
    private LocalDateTime salesDatetime;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "sales_amount", nullable = false)
    private BigDecimal salesAmount;

    public SaleEntity() {}

    public SaleEntity(Long id, ProductEntity product, VendorEntity vendor, LocalDateTime salesDatetime, Integer quantity, BigDecimal salesAmount) {
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
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
