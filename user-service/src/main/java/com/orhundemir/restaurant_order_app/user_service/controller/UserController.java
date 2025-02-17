package com.orhundemir.restaurant_order_app.user_service.controller;


import com.orhundemir.restaurant_order_app.user_service.dto.request.UserRequest;
import com.orhundemir.restaurant_order_app.user_service.dto.response.UserInfoResponse;
import com.orhundemir.restaurant_order_app.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Kullanıcı oluşturma
    @PostMapping
    public ResponseEntity<UserInfoResponse> createUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
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

    @GetMapping("/sellers")
    public ResponseEntity<List<UserInfoResponse>> getAllSellers() {
        List<UserInfoResponse> userInfoResponses = userService.getAllSellers();
        return new ResponseEntity<>(userInfoResponses, HttpStatus.OK);
    }
}
