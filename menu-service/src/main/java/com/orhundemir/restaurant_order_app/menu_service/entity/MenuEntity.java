package com.orhundemir.restaurant_order_app.menu_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class MenuEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;
    private String name;
    private String description;

    private UUID sellerId;  // Her menü bir satıcıya ait olacak(Satıcılar user-servşcede tutuluyor.)


    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItemEntity> menuItems;

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
