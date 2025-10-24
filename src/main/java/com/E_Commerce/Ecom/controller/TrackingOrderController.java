package com.E_Commerce.Ecom.controller;

import com.E_Commerce.Ecom.dto.OrderDto;
import com.E_Commerce.Ecom.services.customer.orders.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TrackingOrderController {

    private final OrderService orderService;

    @GetMapping("/order/{trackingId}")
    public ResponseEntity<OrderDto> searchOrderByTrackingId(@PathVariable UUID trackingId) {
        OrderDto orderDto = orderService.searchOrderByTrackingId(trackingId);
        if (orderDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }
}
