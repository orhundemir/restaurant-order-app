package com.orhundemir.restaurant_order_app.menu_service.dto.response;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private UUID sellerId;
    private List<MenuItemResponseDTO> menuItems;
    private Date createdAt;
    private Date updatedAt;
}
