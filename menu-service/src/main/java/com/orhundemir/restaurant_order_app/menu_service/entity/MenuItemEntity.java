package com.orhundemir.restaurant_order_app.menu_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "menuId", nullable = false)
    private MenuEntity menu;  // Her öğe bir menüye ait olacak

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        this.createdAt = now; // İlk kayıt için oluşturulma tarihi
        this.updatedAt = now; // İlk kayıt için güncelleme tarihi aynı
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date(); // Sadece güncelleme tarihini değiştir
    }
}
