package com.orhundemir.restaurant_order_app.menu_service.controller;

import com.orhundemir.restaurant_order_app.menu_service.dto.request.MenuItemRequestDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.request.MenuRequestDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.response.MenuItemResponseDTO;
import com.orhundemir.restaurant_order_app.menu_service.dto.response.MenuResponseDTO;
import com.orhundemir.restaurant_order_app.menu_service.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menu")
    public ResponseEntity<MenuResponseDTO> createMenu(@RequestBody MenuRequestDTO menuRequestDTO) {
        return ResponseEntity.ok(menuService.createMenu(menuRequestDTO));
    }

    @PostMapping("/addMenuItem/{id}")
    public ResponseEntity<MenuItemResponseDTO> addMenuItem(@PathVariable UUID id, @RequestBody MenuItemRequestDTO menuItemRequestDTO) {
        return ResponseEntity.ok(menuService.addMenuItem(id, menuItemRequestDTO));
    }


    @GetMapping("/{id}")
    public ResponseEntity<MenuResponseDTO> getMenuById(@PathVariable UUID id) {
        return ResponseEntity.ok(menuService.getMenuById(id));
    }

    @GetMapping
    public ResponseEntity<List<MenuResponseDTO>> getAllMenus() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuResponseDTO> updateMenu(@PathVariable UUID id, @RequestBody MenuRequestDTO menuRequestDTO) {
        return ResponseEntity.ok(menuService.updateMenu(id, menuRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable UUID id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}
