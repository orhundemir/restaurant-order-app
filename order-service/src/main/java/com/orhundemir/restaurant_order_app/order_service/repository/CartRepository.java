package com.orhundemir.restaurant_order_app.order_service.repository;

import com.orhundemir.restaurant_order_app.order_service.entity.CartEntity;
import com.orhundemir.restaurant_order_app.order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, UUID> {

    Optional<CartEntity> findByUserId(UUID userId);
}
