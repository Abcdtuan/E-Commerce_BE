package com.E_Commerce.Ecom.services.admin.order;

import com.E_Commerce.Ecom.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    List<OrderDto> getAllOrders();

    OrderDto changeOrderStatus(Long id, String status);
}
