package com.orhundemir.restaurant_order_app.order_service.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class OrderResponse {
    private UUID id; // Sipariş ID'si
    private UUID userId; // Siparişi veren kullanıcının ID'si
    private UUID sellerId; // Siparişin ait olduğu satıcının ID'si
    private List<OrderItemResponse> items; // Sipariş edilen menü öğeleri
    private double totalPrice; // Siparişin toplam tutarı
    private String status; // Sipariş durumu (PENDING, PREPARING, COMPLETED, CANCELED)
    private LocalDateTime createdAt; // Sipariş oluşturulma tarihi
    private LocalDateTime updatedAt; // Son güncellenme tarihi
}