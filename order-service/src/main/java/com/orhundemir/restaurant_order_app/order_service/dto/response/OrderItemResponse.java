package com.orhundemir.restaurant_order_app.order_service.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class OrderItemResponse {
    private UUID id; // Sipariş öğesi ID'si
    private UUID menuItemId; // Menü öğesi ID'si
    private String menuItemName; // Menü öğesi adı (Kolay erişim için)
    private int quantity; // Sipariş edilen miktar
    private double price; // Menü öğesinin birim fiyatı
}