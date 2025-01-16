package com.orhundemir.restaurant_order_app.menu_service.repository;

import com.orhundemir.restaurant_order_app.menu_service.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, UUID> {
}
