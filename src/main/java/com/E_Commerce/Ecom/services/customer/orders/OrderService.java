package com.E_Commerce.Ecom.services.customer.orders;

import com.E_Commerce.Ecom.dto.OrderDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    List<OrderDto> getAllOrders(Long userId);
    OrderDto searchOrderByTrackingId(UUID trackingId);
}
