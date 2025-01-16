package com.orhundemir.restaurant_order_app.menu_service.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemRequestDTO {
    private String name;
    private String description;
    private Double price;
}
