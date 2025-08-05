package com.E_Commerce.Ecom.services.admin.adminproduct;

import com.E_Commerce.Ecom.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface AdminProduct {

    ProductDto addProduct(ProductDto productDto) throws IOException;

    List<ProductDto> getAllProducts();

    List<ProductDto> getAllProductsByName(String name);

    boolean deleteProduct(Long id);
}
