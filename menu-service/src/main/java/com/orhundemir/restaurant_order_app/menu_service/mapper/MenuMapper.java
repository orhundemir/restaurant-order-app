package com.orhundemir.restaurant_order_app.menu_service.mapper;

import com.orhundemir.restaurant_order_app.menu_service.dto.request.MenuRequestDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.response.MenuResponseDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.request.MenuItemRequestDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.response.MenuItemResponseDTO;
import com.orhundemir.restaurant_order_app.menu_service.entity.MenuEntity;
import com.orhundemir.restaurant_order_app.menu_service.entity.MenuItemEntity;

public interface MenuMapper {
    MenuEntity toMenuEntity(MenuRequestDTO menuRequestDTO);

    MenuResponseDTO toMenuResponseDTO(MenuEntity menuEntity);

    MenuItemEntity toMenuItemEntity(MenuItemRequestDTO menuItemRequestDTO);

    MenuItemResponseDTO toMenuItemResponseDTO(MenuItemEntity menuItemEntity);
}
