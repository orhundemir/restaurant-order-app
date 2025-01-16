package com.orhundemir.restaurant_order_app.menu_service.repository;

import com.orhundemir.restaurant_order_app.menu_service.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {

}
