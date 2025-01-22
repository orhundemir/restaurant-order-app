package com.orhundemir.restaurant_order_app.order_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column(nullable = false)
    private UUID userId; // Sepetin ait olduğu kullanıcı ID

    @Column(nullable = false)
    private UUID sellerId; // Sepetin ait olduğu kullanıcı ID

    @Column(nullable = false)
    private String sellerName; // Sepetin ait olduğu kullanıcı ID

    @Column(nullable = false)
    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cartId")
    private List<CartItemEntity> items = new ArrayList<>(); // Sepetteki ürünler
}
