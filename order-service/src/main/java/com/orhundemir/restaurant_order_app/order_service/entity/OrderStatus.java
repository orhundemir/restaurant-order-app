package com.orhundemir.restaurant_order_app.order_service.entity;

public enum OrderStatus {
    PENDING,     // Beklemede
    PREPARING,   // Hazırlanıyor
    COMPLETED,   // Tamamlandı
    CANCELED     // İptal edildi
}
