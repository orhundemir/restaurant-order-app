package com.orhundemir.restaurant_order_app.order_service.mapper;

import com.orhundemir.restaurant_order_app.order_service.dto.request.CartItemRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.request.CartRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.response.CartItemResponse;
import com.orhundemir.restaurant_order_app.order_service.dto.response.CartResponse;
import com.orhundemir.restaurant_order_app.order_service.entity.CartEntity;
import com.orhundemir.restaurant_order_app.order_service.entity.CartItemEntity;
import com.orhundemir.restaurant_order_app.order_service.entity.OrderItemEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CartMapperImpl implements CartMapper {

    @Override
    public CartEntity toCartEntity(CartRequest cartRequestDTO) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUserId(cartRequestDTO.getUserId());
        cartEntity.setSellerId(cartRequestDTO.getSellerId());
        cartEntity.setSellerName(cartRequestDTO.getSellerName());
        cartEntity.setTotalPrice(cartRequestDTO.getTotalPrice());
        cartEntity.setItems(cartRequestDTO.getItems().stream()
                .map(this::toCartItemEntity)
                .collect(Collectors.toList()));

        if (cartRequestDTO.getItems() != null) {
            cartEntity.setItems(cartRequestDTO.getItems().stream()
                    .map(cartItemRequestDTO -> {
                        CartItemEntity cartItemEntity = toCartItemEntity(cartItemRequestDTO);
                        cartItemEntity.setCart(cartEntity); // Parent referansı ayarlanıyor
                        return cartItemEntity;
                    })
                    .collect(Collectors.toList()));
        } else {
            cartEntity.setItems(null);
        }

        return cartEntity;
    }

    @Override
    public CartResponse toCartResponse(CartEntity cartEntity) {
        CartResponse cartResponse = new CartResponse();
        cartResponse.setSellerId(cartEntity.getSellerId());
        cartResponse.setSellerName(cartEntity.getSellerName());
        cartResponse.setId(cartEntity.getId());
        cartResponse.setUserId(cartEntity.getUserId());
        cartResponse.setTotalPrice(cartEntity.getTotalPrice());
        cartResponse.setItems(cartEntity.getItems().stream()
                .map(this::toCartItemResponse)
                .collect(Collectors.toList()));
        return cartResponse;
    }

    @Override
    public CartItemEntity toCartItemEntity(CartItemRequest cartItemRequestDTO) {
        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setMenuItemId(cartItemRequestDTO.getMenuItemId());
        cartItemEntity.setMenuItemName(cartItemRequestDTO.getMenuItemName());
        cartItemEntity.setPrice(cartItemRequestDTO.getPrice());
        cartItemEntity.setQuantity(cartItemRequestDTO.getQuantity());
        return cartItemEntity;
    }

    @Override
    public CartItemResponse toCartItemResponse(CartItemEntity cartItemEntity) {
        CartItemResponse cartItemResponse = new CartItemResponse();
        cartItemResponse.setMenuItemId(cartItemEntity.getMenuItemId());
        cartItemResponse.setMenuName(cartItemEntity.getMenuItemName());
        cartItemResponse.setPrice(cartItemEntity.getPrice());
        cartItemResponse.setQuantity(cartItemEntity.getQuantity());
        return cartItemResponse;
    }
}
