package com.orhundemir.restaurant_order_app.user_service.entity;

import lombok.Getter;


@Getter
public enum RoleEntity {
    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_MOD("MOD"),
    ROLE_SELLER ("SELLER");

    private final String value;

    RoleEntity(String value) {
        this.value = value;
    }

}
