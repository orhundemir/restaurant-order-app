package com.orhundemir.restaurant_order_app.user_service.mapper;

import com.orhundemir.restaurant_order_app.user_service.dto.request.UserRequest;
import com.orhundemir.restaurant_order_app.user_service.dto.response.UserInfoResponse;
import com.orhundemir.restaurant_order_app.user_service.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class MapStructMapperImpl implements MapStructMapper {
    @Override
    public UserRequest toUserRequest(UserEntity userEntity) {

        return UserRequest.builder()
                .address(userEntity.getAddress())
                .name(userEntity.getName())
                .authorities(userEntity.getAuthorities())
                .phoneNumber(userEntity.getPhoneNumber())
                .email(userEntity.getEmail())
                .build();
    }

    @Override
    public UserEntity toUserEntity(UserRequest userDTO) {
        Date now = new Date();
        return UserEntity.builder()
                .address(userDTO.getAddress())
                .name(userDTO.getName())
                .authorities(userDTO.getAuthorities())
                .phoneNumber(userDTO.getPhoneNumber())
                .createdAt(now)
                .password(userDTO.getPassword())
                .updatedAt(now)
                .email(userDTO.getEmail())
                .build();
    }

    @Override
    public UserInfoResponse toUserInfoResponse(UserEntity user) {
        return UserInfoResponse.builder()
                .phoneNumber(user.getPhoneNumber())
                .userId(user.getId())
                .email(user.getEmail())
                .address(user.getAddress())
                .name(user.getName())
                .status(user.isStatus())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
    @Override
    public UserEntity toUserEntity(UserInfoResponse userInfoResponse) {
        return UserEntity.builder()
                .phoneNumber(userInfoResponse.getPhoneNumber())
                .id(userInfoResponse.getUserId())
                .email(userInfoResponse.getEmail())
                .address(userInfoResponse.getAddress())
                .name(userInfoResponse.getName())
                .status(userInfoResponse.isStatus())
                .createdAt(userInfoResponse.getCreatedAt())
                .updatedAt(userInfoResponse.getUpdatedAt())
                .build();
    }
}
