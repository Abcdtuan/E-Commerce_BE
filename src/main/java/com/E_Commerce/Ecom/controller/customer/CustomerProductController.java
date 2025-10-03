package com.E_Commerce.Ecom.controller.customer;

import com.E_Commerce.Ecom.dto.ProductDto;
import com.E_Commerce.Ecom.entity.Product;
import com.E_Commerce.Ecom.services.customer.customerproduct.CustomerProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer/products")
public class CustomerProductController {

    private final CustomerProduct customerProduct;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtos = customerProduct.getAllProducts();
        return  ResponseEntity.status(HttpStatus.CREATED).body(productDtos);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductsByName(@PathVariable String name) {
        List<ProductDto> productDtos = customerProduct.getAllProductsByName(name);
        return  ResponseEntity.status(HttpStatus.CREATED).body(productDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto productOptional = customerProduct.getProductById(id);
        if(productOptional!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
