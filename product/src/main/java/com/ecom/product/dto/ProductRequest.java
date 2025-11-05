package com.ecom.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer stockQuantity;
    private Boolean isActive;
    private String imageUrl;

}
