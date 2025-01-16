package com.orhundemir.restaurant_order_app.user_service.controller;


import com.orhundemir.restaurant_order_app.user_service.dto.request.UserRequest;
import com.orhundemir.restaurant_order_app.user_service.dto.response.UserInfoResponse;
import com.orhundemir.restaurant_order_app.user_service.mapper.MapStructMapperImpl;
import com.orhundemir.restaurant_order_app.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final MapStructMapperImpl mapStructMapper;


    public UserController(UserService userService, MapStructMapperImpl mapStructMapper) {
        this.userService = userService;
        this.mapStructMapper = mapStructMapper;
    }

    // Kullanıcı oluşturma
    @PostMapping
    public ResponseEntity<UserInfoResponse> createUser(@RequestBody UserRequest userRequest) {
        UserInfoResponse userInfoResponse = mapStructMapper.toUserInfoResponse(userService.createUser(userRequest));
        return new ResponseEntity<>(userInfoResponse, HttpStatus.CREATED);
    }

    // Kullanıcı bilgilerini alma
    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable String userId) {
        UserInfoResponse userInfoResponse = userService.getUserInfo(userId);
        return new ResponseEntity<>(userInfoResponse, HttpStatus.OK);
    }

    // Tüm kullanıcıları listeleme
    @GetMapping
    public ResponseEntity<List<UserInfoResponse>> getAllUsers() {
        List<UserInfoResponse> userInfoResponses = userService.getAllUsers();
        return new ResponseEntity<>(userInfoResponses, HttpStatus.OK);
    }
}
