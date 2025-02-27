package com.commerce.cartservice.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class CartItemDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    private int quantity;
    private Double price;
}
