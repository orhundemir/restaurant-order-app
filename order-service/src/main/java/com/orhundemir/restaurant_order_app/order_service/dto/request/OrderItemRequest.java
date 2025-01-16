package com.orhundemir.restaurant_order_app.order_service.dto.request;

import lombok.Data;

import java.util.UUID;
@Data
public class OrderItemRequest {

    private UUID menuItemId; // Menü öğesi ID'si
    private int quantity; // Sipariş edilen miktar
    private double price; // Menü öğesinin birim fiyatı


}
