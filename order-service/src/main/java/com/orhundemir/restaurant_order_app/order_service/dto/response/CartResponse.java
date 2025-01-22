package com.orhundemir.restaurant_order_app.order_service.dto.response;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CartResponse {
    private UUID id;
    private UUID userId;
    private UUID sellerId;
    private String sellerName;
    private List<CartItemResponse> items;
    private double totalPrice;

}
