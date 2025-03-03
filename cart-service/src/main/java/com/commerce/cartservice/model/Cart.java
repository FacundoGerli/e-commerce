package com.commerce.cartservice.model;

import com.commerce.cartservice.DTO.CartItemDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart implements Serializable {
    private String id;
    private List<CartItemDTO> cartItem;
    private double actualPrice;

    public Cart(String userId){
        this.id = userId;
        this.cartItem = new ArrayList<CartItemDTO>();

    }
}
