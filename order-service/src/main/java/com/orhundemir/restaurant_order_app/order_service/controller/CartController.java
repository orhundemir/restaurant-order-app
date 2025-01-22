package com.orhundemir.restaurant_order_app.order_service.controller;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.orhundemir.restaurant_order_app.order_service.dto.request.CartRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.response.CartResponse;
import com.orhundemir.restaurant_order_app.order_service.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Sepet oluşturma veya güncelleme
    @PostMapping
    public ResponseEntity<CartResponse> createOrUpdateCart(@RequestBody CartRequest cartRequest) {
        CartResponse cartResponse = cartService.createOrUpdateCart(cartRequest);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    // Kullanıcıya ait sepeti alma
    @GetMapping("/{userId}")
    public ResponseEntity<CartResponse> getCartByUserId(@PathVariable UUID userId) {
        CartResponse cartResponse = cartService.getCartByUserId(userId);
        return new ResponseEntity<>(cartResponse, HttpStatus.OK);
    }

    // Sepeti temizleme
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> clearCart(@PathVariable UUID userId) {
        cartService.clearCart(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
