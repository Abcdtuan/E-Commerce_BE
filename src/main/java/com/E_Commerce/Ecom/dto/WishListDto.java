package com.E_Commerce.Ecom.dto;

import lombok.Data;

@Data
public class WishListDto {

    private Long id;

    private Long productId;

    private Long userId;

    private String productName;

    private Long price;

    private byte[] returnedImage;
}
