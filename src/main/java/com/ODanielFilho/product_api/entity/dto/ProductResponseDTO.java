package com.ODanielFilho.product_api.entity.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
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
