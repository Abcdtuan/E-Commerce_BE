package com.E_Commerce.Ecom.dto;

import com.E_Commerce.Ecom.enums.PaymentMethod;
import lombok.Data;

@Data
public class PlaceOrderDto {

    Long userId;

    String address;

    String phoneNumber;

    String name;

    String orderDescription;

    PaymentMethod paymentMethod;
}
