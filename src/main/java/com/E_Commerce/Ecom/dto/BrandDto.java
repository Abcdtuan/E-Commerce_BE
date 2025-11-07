package com.E_Commerce.Ecom.dto;

import lombok.Data;

@Data
public class BrandDto {

    private Long id;

    private String name;

    private String description;

    private Long categoryId;
}
