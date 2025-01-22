package com.orhundemir.restaurant_order_app.order_service.dto.request;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CartRequest {
    private UUID userId;
    private List<CartItemRequest> items;
    private UUID sellerId;
    private String sellerName;
    private double totalPrice;
}
