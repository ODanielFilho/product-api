package com.ODanielFilho.product_api.entity.dto;

import java.math.BigDecimal;

public record ProductDTO(
        String name,
        String description,
        BigDecimal price,
        String category,
        String brand,
        Integer quantityInStock,
        String sku,
        BigDecimal weight,
        String dimensions,
        String color,
        String imageUrl,
        String status
) {
}
