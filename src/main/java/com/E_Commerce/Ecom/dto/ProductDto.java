package com.E_Commerce.Ecom.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private Long price;


    private String description;

    private MultipartFile img;

    private byte[] byteImg;

    private Long categoryId;

    private String categoryName;




}
