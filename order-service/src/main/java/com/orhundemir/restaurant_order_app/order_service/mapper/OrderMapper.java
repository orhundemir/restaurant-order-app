package com.orhundemir.restaurant_order_app.order_service.mapper;

import com.orhundemir.restaurant_order_app.order_service.dto.request.OrderItemRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.request.OrderRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.response.OrderItemResponse;
import com.orhundemir.restaurant_order_app.order_service.dto.response.OrderResponse;
import com.orhundemir.restaurant_order_app.order_service.entity.OrderEntity;
import com.orhundemir.restaurant_order_app.order_service.entity.OrderItemEntity;

public interface OrderMapper {

    OrderEntity toOrderEntity(OrderRequest orderRequestDTO);

    OrderResponse toOrderResponse(OrderEntity orderEntity);

    OrderItemEntity toOrderItemEntity(OrderItemRequest orderItemRequestDTO);

    OrderItemResponse toOrderItemResponse(OrderItemEntity orderItemEntity);
}
