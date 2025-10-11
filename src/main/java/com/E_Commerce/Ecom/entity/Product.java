package com.E_Commerce.Ecom.entity;

import com.E_Commerce.Ecom.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Lombok;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    @Lob
    private String description;

//    @Lob
//    @Column(columnDefinition = "longblob")
//    private byte[] img;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ProductImages> images = new ArrayList<>();

    @Lob
    @Column(columnDefinition = "Longblob")
    private Long thumbnailImageId;

    public ProductDto getDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setName(name);
        productDto.setPrice(price);
        productDto.setDescription(description);
        List<byte[]> allImages = images.stream()
                        .map(ProductImages::getImg)
                        .toList();
        productDto.setByteImages(allImages);

        productDto.setThumbnail(allImages.get(0));


        productDto.setCategoryId(category.getId());
        productDto.setCategoryName(category.getName());
        return productDto;

    }
}
