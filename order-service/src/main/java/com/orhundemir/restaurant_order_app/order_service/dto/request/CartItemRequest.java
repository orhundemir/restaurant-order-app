package com.orhundemir.restaurant_order_app.order_service.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public  class CartItemRequest {
    private UUID menuItemId;
    private String menuItemName;
    private double price;
    private int quantity;
}