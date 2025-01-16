package com.orhundemir.restaurant_order_app.menu_service.dto.request;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuRequestDTO {
    private String name;
    private String description;
    private UUID sellerId;
    private List<MenuItemRequestDTO> menuItems;
}
