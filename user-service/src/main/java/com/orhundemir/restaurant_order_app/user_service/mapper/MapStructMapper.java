package com.orhundemir.restaurant_order_app.user_service.mapper;




import com.orhundemir.restaurant_order_app.user_service.dto.request.UserRequest;
import com.orhundemir.restaurant_order_app.user_service.dto.response.UserInfoResponse;
import com.orhundemir.restaurant_order_app.user_service.entity.UserEntity;


public interface MapStructMapper {

    UserRequest toUserRequest(UserEntity userEntity);
    UserEntity toUserEntity(UserRequest userDTO);


    UserInfoResponse toUserInfoResponse(UserEntity user);
    UserEntity toUserEntity(UserInfoResponse userInfoResponse);




}
