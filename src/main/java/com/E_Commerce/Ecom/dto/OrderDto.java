package com.E_Commerce.Ecom.dto;

import com.E_Commerce.Ecom.entity.CartItems;
import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {
    private Long id;

    private String orderDescription;

    private OrderStatus orderStatus;

    private Date date;

    private  String address;

    private String paymentMethod;

    private String phone;

    private Long amount;

    private Long totalAmount;

    private Long discount;

    private UUID trackingId;

    private String  userName;

    private String couponName;

    private List<CartItemsDto> cartItems;


}
