package com.orhundemir.restaurant_order_app.order_service.mapper;

import com.orhundemir.restaurant_order_app.order_service.dto.request.OrderRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.request.OrderItemRequest;
import com.orhundemir.restaurant_order_app.order_service.dto.response.OrderItemResponse;
import com.orhundemir.restaurant_order_app.order_service.dto.response.OrderResponse;
import com.orhundemir.restaurant_order_app.order_service.entity.OrderEntity;
import com.orhundemir.restaurant_order_app.order_service.entity.OrderItemEntity;
import com.orhundemir.restaurant_order_app.order_service.entity.OrderStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderEntity toOrderEntity(OrderRequest orderRequestDTO) {
        if (orderRequestDTO == null) {
            return null;
        }
        LocalDateTime now = LocalDateTime.now();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(orderRequestDTO.getUserId());
        orderEntity.setSellerId(orderRequestDTO.getSellerId());
        orderEntity.setTotalPrice(orderRequestDTO.getTotalPrice());
        if(orderRequestDTO.getStatus()!=null)
            orderEntity.setStatus(OrderStatus.valueOf(orderRequestDTO.getStatus()));
        orderEntity.setCreatedAt(now);
        orderEntity.setUpdatedAt(now);

        if (orderRequestDTO.getItems() != null) {
            orderEntity.setItems(orderRequestDTO.getItems().stream()
                    .map(orderItemRequestDTO -> {
                        OrderItemEntity orderItemEntity = toOrderItemEntity(orderItemRequestDTO);
                        orderItemEntity.setOrder(orderEntity); // Parent referansı ayarlanıyor
                        return orderItemEntity;
                    })
                    .collect(Collectors.toList()));
        } else {
            orderEntity.setItems(null);
        }

        return orderEntity;
    }

    @Override
    public OrderResponse toOrderResponse(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }

        OrderResponse orderResponseDTO = new OrderResponse();
        orderResponseDTO.setId(orderEntity.getId());
        orderResponseDTO.setUserId(orderEntity.getUserId());
        orderResponseDTO.setSellerId(orderEntity.getSellerId());
        orderResponseDTO.setTotalPrice(orderEntity.getTotalPrice());
        orderResponseDTO.setCreatedAt(orderEntity.getCreatedAt());
        orderResponseDTO.setUpdatedAt(orderEntity.getUpdatedAt());
        orderResponseDTO.setItems(orderEntity.getItems() != null
                ? orderEntity.getItems().stream()
                .map(this::toOrderItemResponse)
                .collect(Collectors.toList())
                : null);

        return orderResponseDTO;
    }

    public OrderItemEntity toOrderItemEntity(OrderItemRequest orderItemRequestDTO) {
        if (orderItemRequestDTO == null) {
            return null;
        }
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setMenuItemId(orderItemRequestDTO.getMenuItemId());
        orderItemEntity.setQuantity(orderItemRequestDTO.getQuantity());
        orderItemEntity.setPrice(orderItemRequestDTO.getPrice());

        return orderItemEntity;
    }

    @Override
    public OrderItemResponse toOrderItemResponse(OrderItemEntity orderItemEntity) {
        if (orderItemEntity == null) {
            return null;
        }

        OrderItemResponse orderItemResponseDTO = new OrderItemResponse();
        orderItemResponseDTO.setId(orderItemEntity.getId());
        orderItemResponseDTO.setMenuItemId(orderItemEntity.getMenuItemId());
        orderItemResponseDTO.setMenuItemName(orderItemEntity.getMenuItemName());
        orderItemResponseDTO.setQuantity(orderItemEntity.getQuantity());
        orderItemResponseDTO.setPrice(orderItemEntity.getPrice());

        return orderItemResponseDTO;
    }
}
