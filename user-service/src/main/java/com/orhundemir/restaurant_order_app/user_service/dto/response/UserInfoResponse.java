package com.orhundemir.restaurant_order_app.user_service.dto.response;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserInfoResponse {
    UUID userId;
    String name;
    String email;
    String address;
    String phoneNumber;
    boolean status;
    Date createdAt;
    Date updatedAt;

}
