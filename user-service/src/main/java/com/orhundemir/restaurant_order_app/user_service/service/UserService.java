package com.orhundemir.restaurant_order_app.user_service.service;

import com.orhundemir.restaurant_order_app.user_service.dto.request.UserRequest;
import com.orhundemir.restaurant_order_app.user_service.dto.response.UserInfoResponse;
import com.orhundemir.restaurant_order_app.user_service.entity.UserEntity;
import com.orhundemir.restaurant_order_app.user_service.mapper.UserMapper;
import com.orhundemir.restaurant_order_app.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserInfoResponse createUser(UserRequest userRequest) {
        UserEntity user = userRepository.save(userMapper.toEntity(userRequest));
        return userMapper.toResponse(user);
    }

    public UserInfoResponse getUserInfo(String userId) {
        return userMapper.toResponse(userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found")));
    }

    public List<UserInfoResponse> getAllUsers() {
        return userMapper.toResponseList(userRepository.findAll());
    }

    public List<UserInfoResponse> getAllSellers() {
        List<UserEntity> userList = userRepository.findAll()
                .stream()
                .filter(user -> user.getAuthorities().stream()
                        .anyMatch(role -> "SELLER".equals(role.getValue()))).toList(); // RoleName "ROLE_SELLER" kontrolü

        return userMapper.toResponseList(userList);
    }


}
