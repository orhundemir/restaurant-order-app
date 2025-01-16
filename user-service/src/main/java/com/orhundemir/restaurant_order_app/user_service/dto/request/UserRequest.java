package com.orhundemir.restaurant_order_app.user_service.dto.request;


import com.orhundemir.restaurant_order_app.user_service.entity.RoleEntity;
import lombok.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
     String name;
     String email;
     String password;
     String address;
     String phoneNumber;
     Set<RoleEntity> authorities;
 }
