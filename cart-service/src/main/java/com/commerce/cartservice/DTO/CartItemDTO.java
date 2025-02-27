package com.commerce.cartservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CartItemDTO {
    private Long itemId;
    private int quantity;
    private Double price;
}
