package com.example.ecommerce.migration.core.infrastructure.mongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "products")
public class ProductDocument {
    @Id
    private String id;
    private String description;
    private BigDecimal price;
    private LocalDate entryDate;
    private Integer stockQuantity;
    private LocalDate expirationDate;

    public ProductDocument() {
    }

    public ProductDocument(String id, String description, BigDecimal price, LocalDate entryDate, Integer stockQuantity, LocalDate expirationDate) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.entryDate = entryDate;
        this.stockQuantity = stockQuantity;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
