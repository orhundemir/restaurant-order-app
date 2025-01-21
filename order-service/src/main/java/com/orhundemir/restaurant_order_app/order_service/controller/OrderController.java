package com.orhundemir.restaurant_order_app.order_service.controller;

import com.orhundemir.restaurant_order_app.order_service.dto.request.OrderRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.response.OrderResponse;
import com.orhundemir.restaurant_order_app.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create Order
    @PostMapping("/order")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    // Get Order by ID
    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable UUID orderId) {
        OrderResponse orderResponse = orderService.getOrderById(orderId);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderResponse>> getOrderByUserId(@PathVariable UUID userId) {
        List<OrderResponse> orderResponse = orderService.getOrderByUserId(userId);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}
