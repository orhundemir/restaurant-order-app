package com.orhundemir.restaurant_order_app.user_service.dto.response;

import com.orhundemir.restaurant_order_app.user_service.entity.RoleEntity;
import lombok.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    UUID userId;
    String name;
    String email;
    String address;
    String phoneNumber;
    boolean status;
    Date createdAt;
    Date updatedAt;
    Set<RoleEntity> authorities;

}
