package com.orhundemir.restaurant_order_app.order_service.dto.request;



import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderRequest {
    private UUID userId; // Siparişi veren kullanıcının ID'si
    private UUID sellerId; // Siparişin ait olduğu satıcının ID'si
    private List<OrderItemRequest> items; // Sipariş edilen menü öğeleri
    private double totalPrice; // Siparişin toplam tutarı
    private String status; // Sipariş durumu (PENDING, PREPARING, COMPLETED, CANCELED)
}
