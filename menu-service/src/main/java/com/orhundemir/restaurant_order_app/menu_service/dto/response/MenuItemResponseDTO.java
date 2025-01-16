package com.orhundemir.restaurant_order_app.menu_service.dto.response;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Date createdAt;
    private Date updatedAt;
}
