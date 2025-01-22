package com.orhundemir.restaurant_order_app.order_service.mapper;

import com.orhundemir.restaurant_order_app.order_service.dto.request.CartItemRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.request.CartRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.response.CartItemResponse;
import com.orhundemir.restaurant_order_app.order_service.dto.response.CartResponse;
import com.orhundemir.restaurant_order_app.order_service.entity.CartEntity;
import com.orhundemir.restaurant_order_app.order_service.entity.CartItemEntity;


public interface CartMapper {

    CartEntity toCartEntity(CartRequest cartRequestDTO);
    CartResponse toCartResponse(CartEntity cartEntity);
    CartItemEntity toCartItemEntity(CartItemRequest cartItemRequestDTO);
    CartItemResponse toCartItemResponse(CartItemEntity cartItemEntity);
}
