package com.E_Commerce.Ecom.controller.customer;

import com.E_Commerce.Ecom.dto.OrderDto;
import com.E_Commerce.Ecom.services.customer.orders.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/placedOrders/{userId}")
    public ResponseEntity<List<OrderDto>> getAllOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getAllOrders(userId));
    }

}
