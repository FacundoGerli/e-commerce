package com.commerce.cartservice.service;

import com.commerce.cartservice.DTO.CartItemDTO;
import com.commerce.cartservice.model.Cart;

public interface ICartService {

    public Cart getCart(String idUser);
    public Cart addToCart(String idUser, CartItemDTO item);
    public Cart removeItem(String idUser, Long productId);
    public void clearCart(String idUser);
    public double calculeTotal(Cart cart);
}


