package com.E_Commerce.Ecom.dto;

import lombok.Data;

@Data
public class PlaceOrderDto {

    Long userId;

    String address;

    String phoneNumber;

    String name;

    String orderDescription;
}
