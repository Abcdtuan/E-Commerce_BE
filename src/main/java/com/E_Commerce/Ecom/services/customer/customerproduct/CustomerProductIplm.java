package com.E_Commerce.Ecom.services.customer.customerproduct;


import com.E_Commerce.Ecom.dto.ProductDto;
import com.E_Commerce.Ecom.entity.Category;
import com.E_Commerce.Ecom.entity.Product;
import com.E_Commerce.Ecom.repository.CategoryRepository;
import com.E_Commerce.Ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProductIplm implements CustomerProduct {

    private final ProductRepository productRepository;

    @Override
    public Page<ProductDto> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(Product::getDto);
    }

    @Override
    public List<ProductDto> getAllProductsByName(String name){
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(Product::getDto).orElse(null);
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId){
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
}
