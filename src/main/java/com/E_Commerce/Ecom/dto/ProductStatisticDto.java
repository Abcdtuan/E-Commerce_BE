package com.E_Commerce.Ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStatisticDto {

    private Long productId;
    private String name;
    private byte[] thumbnail;
    private Long price;
    private Long quantitySold;
}
