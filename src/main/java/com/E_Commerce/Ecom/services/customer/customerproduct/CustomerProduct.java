package com.E_Commerce.Ecom.services.customer.customerproduct;

import com.E_Commerce.Ecom.dto.ProductDto;

import java.util.List;

public interface CustomerProduct {
    List<ProductDto> getAllProducts();

    List<ProductDto> getAllProductsByName(String name);
}
