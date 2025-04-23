package com.example.ecommerce.migration.core.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private Long id;
    private Product product;
    private Vendor vendor;
    private LocalDateTime salesDatetime;
    private Integer quantity;
    private BigDecimal salesAmount;
}