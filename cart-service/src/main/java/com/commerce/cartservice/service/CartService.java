package com.commerce.cartservice.service;

import com.commerce.cartservice.DTO.CartItemDTO;
import com.commerce.cartservice.model.Cart;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService{
    private final RedisTemplate<String, Object> redisTemplate;

    public CartService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Cart getCart(String userId) {
        Cart cart = (Cart) redisTemplate.opsForValue().get("cart" + userId);
        if(cart == null) {
            cart = new Cart(userId);
            redisTemplate.opsForValue().set("cart" + userId, cart);
        }
        return cart;
    }

    @Override
    public Cart addToCart(String userId, CartItemDTO item) {
        var cart = getCart(userId);
        cart.getCartItem().stream()
                .filter(i -> i.getItemId().equals(item.getItemId()))
                .findFirst()
                .ifPresentOrElse(
                        i -> i.setQuantity(i.getQuantity() + item.getQuantity()),
                        () -> cart.getCartItem().add(item)
                );
        cart.setActualPrice(calculeTotal(cart));
        redisTemplate.opsForValue().set("cart" + userId, cart);
        return cart;

    }

    @Override
    public Cart removeItem(String userId, Long productId) {
        var cart = getCart(userId);
        cart.getCartItem().removeIf(i -> i.getItemId().equals(productId));
        cart.setActualPrice(calculeTotal(cart));
        redisTemplate.opsForValue().set("cart" + userId, cart);
        return cart;
    }

    @Override
    public void clearCart(String userId) {
        redisTemplate.delete("cart" + userId);
    }

    @Override
    public double calculeTotal(Cart cart) {
        return cart.getCartItem().stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
