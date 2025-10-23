package com.E_Commerce.Ecom.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private Long price;

    private String description;

    private List<MultipartFile> images;

    private List<byte[]> byteImages;

    private byte[] thumbnail;

    private Long categoryId;

    private String categoryName;

    private Long quantity;

    private Boolean reviewed;




}
