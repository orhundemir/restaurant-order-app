package com.orhundemir.restaurant_order_app.order_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId", nullable = false)
    private CartEntity cart; // Siparişin kendisi

    @Column(nullable = false)
    private UUID menuItemId; // Ürün ID

    @Column(nullable = false)
    private String menuItemName; // Ürün ismi

    @Column(nullable = false)
    private double price; // Ürün fiyatı

    @Column(nullable = false)
    private int quantity; // Ürün miktarı
}
