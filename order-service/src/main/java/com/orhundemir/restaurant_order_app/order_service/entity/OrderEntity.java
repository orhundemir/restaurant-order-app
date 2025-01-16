package com.orhundemir.restaurant_order_app.order_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column(nullable = false)
    private UUID userId; // Siparişi veren kullanıcının ID'si

    @Column(nullable = false)
    private UUID sellerId; // Siparişin ait olduğu satıcının ID'si

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> items; // Sipariş edilen menü öğeleri

    @Column(nullable = false)
    private double totalPrice; // Siparişin toplam tutarı

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status; // Sipariş durumu (PENDING, PREPARING, COMPLETED, CANCELED)

    @Column(nullable = false)
    private LocalDateTime createdAt; // Sipariş oluşturulma tarihi

    @Column(nullable = false)
    private LocalDateTime updatedAt; // Son güncellenme tarihi
}
