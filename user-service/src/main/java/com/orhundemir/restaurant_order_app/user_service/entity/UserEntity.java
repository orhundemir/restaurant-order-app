package com.orhundemir.restaurant_order_app.user_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;


    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String address;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column( nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ColumnDefault(value = "true")
    private boolean status;


    @ElementCollection(targetClass = RoleEntity.class, fetch = FetchType.LAZY)
    @JoinTable(name = "Role", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "roleName", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<RoleEntity> authorities;
}