package com.E_Commerce.Ecom.services.customer.customerproduct;

import com.E_Commerce.Ecom.dto.ProductDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerProduct {
    Page<ProductDto> getAllProducts(int page, int size);

    List<ProductDto> getAllProductsByName(String name);

    ProductDto getProductById(Long id);
}
