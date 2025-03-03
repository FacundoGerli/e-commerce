package com.commerce.cartservice.controller;

import com.commerce.cartservice.DTO.CartItemDTO;
import com.commerce.cartservice.model.Cart;
import com.commerce.cartservice.service.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/cart")
@RestController
public class CartController {
    private final ICartService cartService;
    private final RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/get")
    public Cart getCart(@AuthenticationPrincipal Jwt jwt){
        String userId = jwt.getSubject();
        System.out.println(userId);
        return cartService.getCart(userId);
    }
    @PostMapping("/add")
    public Cart addToCart(@AuthenticationPrincipal Jwt jwt , @RequestBody CartItemDTO item){
        String userId = jwt.getSubject();
        return cartService.addToCart(userId, item);
    }
    @DeleteMapping("/deleteItem/{idItem}")
    public Cart deleteItem(@AuthenticationPrincipal Jwt jwt , @PathVariable Long idItem ){
        String userId = jwt.getSubject();
        return cartService.removeItem(userId,idItem );
    }
    @DeleteMapping("/clear")
    public void clearCart(@AuthenticationPrincipal Jwt jwt){
        String userId = jwt.getSubject();
        cartService.clearCart(userId);
    }
    @GetMapping("/value")
    public double calculeValue(@RequestBody Cart cart){
        return cartService.calculeTotal(cart);
    }
}
