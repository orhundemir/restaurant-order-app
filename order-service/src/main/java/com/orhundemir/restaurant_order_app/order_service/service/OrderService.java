package com.orhundemir.restaurant_order_app.order_service.service;

import com.orhundemir.restaurant_order_app.order_service.dto.request.OrderRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.response.OrderResponse;
import com.orhundemir.restaurant_order_app.order_service.entity.OrderEntity;
import com.orhundemir.restaurant_order_app.order_service.mapper.OrderMapper;
import com.orhundemir.restaurant_order_app.order_service.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    // Create Order
    public OrderResponse createOrder(OrderRequest orderRequest) {
        OrderEntity orderEntity = orderMapper.toOrderEntity(orderRequest);
        OrderEntity savedOrder = orderRepository.save(orderEntity);
        return orderMapper.toOrderResponse(savedOrder);
    }

    // Get Order by ID
    public OrderResponse getOrderById(UUID orderId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        return orderEntity.map(orderMapper::toOrderResponse)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
    }

    // Get Order by ID
    public List<OrderResponse> getOrderByUserId(UUID userId) {
        List<OrderEntity> orderEntities= orderRepository.findAllByUserId(userId);
        List<OrderResponse> result = orderEntities.stream().map(orderMapper::toOrderResponse).toList();
        return result;
    }
}
