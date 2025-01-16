package com.orhundemir.restaurant_order_app.order_service.dto.request;

import com.orhundemir.restaurant_order_app.order_service.entity.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OrderRequest {

    private UUID userId; // Sipariş veren kullanıcının ID'si
    private UUID sellerId; // Satıcının ID'si
    private double totalPrice; // Siparişin toplam tutarı


    private List<OrderItemRequest> items; // Sipariş edilen menü öğeleri

}
