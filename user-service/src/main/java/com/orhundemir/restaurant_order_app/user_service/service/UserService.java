package com.orhundemir.restaurant_order_app.user_service.service;

import com.orhundemir.restaurant_order_app.user_service.dto.request.UserRequest;
import com.orhundemir.restaurant_order_app.user_service.dto.response.UserInfoResponse;
import com.orhundemir.restaurant_order_app.user_service.entity.UserEntity;
import com.orhundemir.restaurant_order_app.user_service.mapper.MapStructMapperImpl;
import com.orhundemir.restaurant_order_app.user_service.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MapStructMapperImpl mapStructMapper;


    public UserService(UserRepository userRepository, MapStructMapperImpl mapStructMapper) {
        this.userRepository = userRepository;
        this.mapStructMapper = mapStructMapper;
    }

    public UserEntity createUser(UserRequest userRequest) {
        return userRepository.save(mapStructMapper.toUserEntity(userRequest));
    }

    public UserInfoResponse getUserInfo(String userId) {
        return mapStructMapper.toUserInfoResponse(userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found")));
    }

    public List<UserInfoResponse> getAllUsers() {
        return userRepository.findAll().stream().map(mapStructMapper::toUserInfoResponse).collect(Collectors.toList());
    }
    public List<UserInfoResponse> getAllSellers() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getAuthorities().stream()
                        .anyMatch(role -> "SELLER".equals(role.getValue()))) // RoleName "ROLE_SELLER" kontrolü
                .map(mapStructMapper::toUserInfoResponse)
                .collect(Collectors.toList());
    }


}
