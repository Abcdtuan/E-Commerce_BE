package com.E_Commerce.Ecom.dto;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class CategoryDto {

    private Long id;

    private String name;

    @Lob
    private String description;

}
