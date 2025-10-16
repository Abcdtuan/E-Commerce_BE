package com.E_Commerce.Ecom.services.customer.orders;

import com.E_Commerce.Ecom.dto.OrderDto;

import java.util.List;

public interface OrderService {

    public List<OrderDto> getAllOrders(Long userId);
}
