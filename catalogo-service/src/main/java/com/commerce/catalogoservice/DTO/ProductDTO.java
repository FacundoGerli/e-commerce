package com.commerce.catalogoservice.DTO;

import lombok.Builder;

@Builder
public record ProductDTO(
        Long id,
        String productName,
        String productDescription,
        Double unitPrice
) {
}