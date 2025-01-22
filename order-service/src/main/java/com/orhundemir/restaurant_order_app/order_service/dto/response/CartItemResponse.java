package com.orhundemir.restaurant_order_app.order_service.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CartItemResponse {
    private UUID id;
    private UUID menuItemId;
    private String menuName;
    private double price;
    private double quantity;
}