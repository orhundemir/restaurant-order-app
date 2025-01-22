package com.orhundemir.restaurant_order_app.order_service.service;

import com.orhundemir.restaurant_order_app.order_service.dto.request.CartRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.response.CartResponse;
import com.orhundemir.restaurant_order_app.order_service.entity.CartEntity;
import com.orhundemir.restaurant_order_app.order_service.mapper.CartMapper;
import com.orhundemir.restaurant_order_app.order_service.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    @Transactional
    public CartResponse createOrUpdateCart(CartRequest cartRequest) {
        CartEntity cartEntity = cartMapper.toCartEntity(cartRequest);

        // Total price hesaplama
        double totalPrice = cartEntity.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
        cartEntity.setTotalPrice(totalPrice);

        CartEntity savedCart = cartRepository.save(cartEntity);
        return cartMapper.toCartResponse(savedCart);
    }

    @Transactional(readOnly = true)
    public CartResponse getCartByUserId(UUID userId) {
        Optional<CartEntity> cartEntity = cartRepository.findByUserId(userId);
        if (cartEntity.isEmpty()) {
            throw new RuntimeException("Cart not found for user ID: " + userId);
        }
        return cartMapper.toCartResponse(cartEntity.get());
    }

    @Transactional
    public void clearCart(UUID userId) {
        Optional<CartEntity> cartEntity = cartRepository.findByUserId(userId);
        cartEntity.ifPresent(cartRepository::delete);
    }
}
