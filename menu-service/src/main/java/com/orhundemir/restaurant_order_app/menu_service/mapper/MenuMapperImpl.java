package com.orhundemir.restaurant_order_app.menu_service.mapper;

import com.orhundemir.restaurant_order_app.menu_service.dto.request.MenuRequestDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.response.MenuResponseDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.request.MenuItemRequestDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.response.MenuItemResponseDTO;
import com.orhundemir.restaurant_order_app.menu_service.entity.MenuEntity;
import com.orhundemir.restaurant_order_app.menu_service.entity.MenuItemEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuMapperImpl implements MenuMapper {

    @Override
    public MenuEntity toMenuEntity(MenuRequestDTO menuRequestDTO) {
        if (menuRequestDTO == null) {
            return null;
        }
        Date now = new Date();
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setName(menuRequestDTO.getName());
        menuEntity.setDescription(menuRequestDTO.getDescription());
        menuEntity.setSellerId(menuRequestDTO.getSellerId());
        menuEntity.setCreatedAt(now);
        menuEntity.setUpdatedAt(now);

        // Parent-child ilişkiyi ayarla
        if (menuRequestDTO.getMenuItems() != null) {
            menuEntity.setMenuItems(menuRequestDTO.getMenuItems().stream()
                    .map(menuItemDTO -> {
                        MenuItemEntity menuItemEntity = toMenuItemEntity(menuItemDTO);
                        menuItemEntity.setMenu(menuEntity); // Parent referansı ayarlanıyor
                        return menuItemEntity;
                    })
                    .collect(Collectors.toList()));
        } else {
            menuEntity.setMenuItems(null);
        }

        return menuEntity;
    }

    @Override
    public MenuResponseDTO toMenuResponseDTO(MenuEntity menuEntity) {
        if (menuEntity == null) {
            return null;
        }

        MenuResponseDTO menuResponseDTO = new MenuResponseDTO();
        menuResponseDTO.setId(menuEntity.getId());
        menuResponseDTO.setName(menuEntity.getName());
        menuResponseDTO.setDescription(menuEntity.getDescription());
        menuResponseDTO.setSellerId(menuEntity.getSellerId());
        menuResponseDTO.setCreatedAt(menuEntity.getCreatedAt());
        menuResponseDTO.setUpdatedAt(menuEntity.getUpdatedAt());
        menuResponseDTO.setMenuItems(menuEntity.getMenuItems() != null
                ? menuEntity.getMenuItems().stream()
                .map(this::toMenuItemResponseDTO)
                .collect(Collectors.toList())
                : null);

        return menuResponseDTO;
    }

    @Override
    public MenuItemEntity toMenuItemEntity(MenuItemRequestDTO menuItemRequestDTO) {
        if (menuItemRequestDTO == null) {
            return null;
        }
        Date now = new Date();
        MenuItemEntity menuItemEntity = new MenuItemEntity();
        menuItemEntity.setName(menuItemRequestDTO.getName());
        menuItemEntity.setDescription(menuItemRequestDTO.getDescription());
        menuItemEntity.setPrice(menuItemRequestDTO.getPrice());
        menuItemEntity.setCreatedAt(now);
        menuItemEntity.setUpdatedAt(now);

        return menuItemEntity;
    }

    @Override
    public MenuItemResponseDTO toMenuItemResponseDTO(MenuItemEntity menuItemEntity) {
        if (menuItemEntity == null) {
            return null;
        }

        MenuItemResponseDTO menuItemResponseDTO = new MenuItemResponseDTO();
        menuItemResponseDTO.setId(menuItemEntity.getId());
        menuItemResponseDTO.setName(menuItemEntity.getName());
        menuItemResponseDTO.setDescription(menuItemEntity.getDescription());
        menuItemResponseDTO.setPrice(menuItemEntity.getPrice());
        menuItemResponseDTO.setCreatedAt(menuItemEntity.getCreatedAt());
        menuItemResponseDTO.setUpdatedAt(menuItemEntity.getUpdatedAt());

        return menuItemResponseDTO;
    }
}
