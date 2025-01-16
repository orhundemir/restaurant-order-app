package com.orhundemir.restaurant_order_app.order_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order; // Siparişin kendisi

    @Column(nullable = false)
    private UUID menuItemId; // Menü öğesi ID'si

    @Column(nullable = false)
    private String menuItemName; // Menü öğesi adı (Kolay erişim için)

    @Column(nullable = false)
    private int quantity; // Sipariş edilen miktar

    @Column(nullable = false)
    private double price; // Menü öğesinin birim fiyatı
}
