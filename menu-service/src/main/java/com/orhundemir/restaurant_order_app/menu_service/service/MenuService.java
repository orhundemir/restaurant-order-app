package com.orhundemir.restaurant_order_app.menu_service.service;

import com.orhundemir.restaurant_order_app.menu_service.dto.request.MenuItemRequestDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.request.MenuRequestDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.response.MenuItemResponseDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.response.MenuResponseDTO;
import com.orhundemir.restaurant_order_app.menu_service.entity.MenuEntity;
import com.orhundemir.restaurant_order_app.menu_service.entity.MenuItemEntity;
import com.orhundemir.restaurant_order_app.menu_service.mapper.MenuMapper;
import com.orhundemir.restaurant_order_app.menu_service.repository.MenuItemRepository;
import com.orhundemir.restaurant_order_app.menu_service.repository.MenuRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;
    private final MenuMapper menuMapper;

    public MenuResponseDTO createMenu(MenuRequestDTO menuRequestDTO) {
        // MenuEntity oluştur
        MenuEntity menuEntity = menuMapper.toMenuEntity(menuRequestDTO);

        // Veritabanına kaydet
        MenuEntity savedMenu = menuRepository.save(menuEntity);

        savedMenu.getMenuItems().forEach(menuItem -> {menuItem.setSellerId(savedMenu.getId());});
        return menuMapper.toMenuResponseDTO(savedMenu);
    }

    @Transactional
    public MenuItemResponseDTO addMenuItem(UUID menuId, MenuItemRequestDTO menuItemRequestDTO) {

        MenuEntity menuEntity = menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with ID: " + menuId));

        MenuItemEntity menuItemEntity = menuMapper.toMenuItemEntity(menuItemRequestDTO);
        menuItemEntity.setMenu(menuEntity);
        menuItemEntity = menuItemRepository.save(menuItemEntity);
        return menuMapper.toMenuItemResponseDTO(menuItemEntity);
    }

    public MenuResponseDTO getMenuById(UUID menuId) {
        // Menü var mı kontrol et
        MenuEntity menuEntity = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        // Menü DTO'su döndür
        return menuMapper.toMenuResponseDTO(menuEntity);
    }


    public List<MenuResponseDTO> getMenusBySellerIds(List<UUID> sellerIds) {
        // Veritabanından sellerId'ye göre menüleri al
        List<MenuEntity> menus = menuRepository.findBySellerIdIn(sellerIds);

        // Menüleri DTO'ya dönüştür ve döndür
        return menus.stream()
                .map(menuMapper::toMenuResponseDTO)
                .collect(Collectors.toList());
    }


    public List<MenuResponseDTO> getAllMenus() {
        // Tüm menüleri getir
        List<MenuEntity> menus = menuRepository.findAll();

        // DTO'lara dönüştür ve liste olarak döndür
        return menus.stream()
                .map(menuMapper::toMenuResponseDTO)
                .collect(Collectors.toList());
    }

    public MenuResponseDTO updateMenu(UUID menuId, MenuRequestDTO menuRequestDTO) {
        // Menü var mı kontrol et
        MenuEntity existingMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        // Güncelleme işlemi
        existingMenu.setName(menuRequestDTO.getName());
        existingMenu.setDescription(menuRequestDTO.getDescription());
        existingMenu.setSellerId(menuRequestDTO.getSellerId());

        // Menü öğelerini güncelle (isteğe bağlı)
        if (menuRequestDTO.getMenuItems() != null) {
            existingMenu.getMenuItems().clear();
            existingMenu.getMenuItems().addAll(
                    menuRequestDTO.getMenuItems().stream()
                            .map(menuMapper::toMenuItemEntity)
                            .collect(Collectors.toList())
            );
        }

        // Güncellenmiş menüyü kaydet
        MenuEntity updatedMenu = menuRepository.save(existingMenu);

        // Güncellenmiş DTO döndür
        return menuMapper.toMenuResponseDTO(updatedMenu);
    }

    public void deleteMenu(UUID menuId) {
        // Menü var mı kontrol et
        MenuEntity menuEntity = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found with id: " + menuId));

        // Menü sil
        menuRepository.delete(menuEntity);
    }
}
