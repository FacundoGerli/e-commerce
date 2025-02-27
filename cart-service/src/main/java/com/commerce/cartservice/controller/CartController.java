package com.commerce.cartservice.controller;

import com.commerce.cartservice.DTO.CartItemDTO;
import com.commerce.cartservice.model.Cart;
import com.commerce.cartservice.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/cart")
@RestController
public class CartController {
    private final ICartService cartService;
    private final RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/get")
    public Cart getCart(@RequestHeader(value = "X-User-Id") String userId){
        return cartService.getCart(userId);
    }
    @PostMapping("/add")
    public Cart addToCart(@RequestHeader(value = "X-User-Id") String userId, @RequestBody CartItemDTO item){
        return cartService.addToCart(userId, item);
    }
    @DeleteMapping("/deleteItem/{idItem}")
    public Cart deleteItem(@RequestHeader(value = "X-User-Id") String userId, @PathVariable Long idItem ){
        return cartService.removeItem(userId,idItem );
    }
    @DeleteMapping("/clear")
    public void clearCart(@RequestHeader(value = "X-User-Id") String userId){
        cartService.clearCart(userId);
    }
    @GetMapping("/value")
    public double calculeValue(@RequestBody Cart cart){
        return cartService.calculeTotal(cart);
    }
}
