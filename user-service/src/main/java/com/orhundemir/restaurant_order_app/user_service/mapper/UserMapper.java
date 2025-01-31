package com.orhundemir.restaurant_order_app.user_service.mapper;




import com.orhundemir.restaurant_order_app.user_service.dto.request.UserRequest;
import com.orhundemir.restaurant_order_app.user_service.dto.response.UserInfoResponse;
import com.orhundemir.restaurant_order_app.user_service.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserRequest userRequest);
    @Mapping(source = "id", target = "userId")
    UserInfoResponse toResponse(UserEntity userEntity);
    List<UserInfoResponse> toResponseList(List<UserEntity> users);




}
