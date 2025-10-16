package com.E_Commerce.Ecom.services.admin.order;

import com.E_Commerce.Ecom.dto.OrderDto;
import com.E_Commerce.Ecom.entity.Order;
import com.E_Commerce.Ecom.enums.OrderStatus;
import com.E_Commerce.Ecom.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("adminOrderService")
@RequiredArgsConstructor

public class OrderServiceIplm implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders(){
        List<Order> orderList = orderRepository.findAllByOrderStatusIn(List.of(OrderStatus.PLACED, OrderStatus.SHIPPED, OrderStatus.DELIVERED));

        return orderList.stream().map(Order::getOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto changeOrderStatus(Long id, String status) {
         Optional<Order> optionalOrder = orderRepository.findById(id);
         if(optionalOrder.isPresent()) {
             Order order = optionalOrder.get();
             if(Objects.equals(status, "Shipped")) {
                 order.setOrderStatus(OrderStatus.SHIPPED);
             } else if (Objects.equals(status, "Delivered")) {
                 order.setOrderStatus(OrderStatus.DELIVERED);
             }
             return orderRepository.save(order).getOrderDto();
         }
         return null;
    }
}
