package com.E_Commerce.Ecom.controller.admin;
import com.E_Commerce.Ecom.dto.ProductDto;
import com.E_Commerce.Ecom.entity.Product;
import com.E_Commerce.Ecom.services.admin.adminproduct.AdminProduct;
import com.E_Commerce.Ecom.services.admin.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminProductController {

    private final AdminProduct adminProduct;

    @PostMapping("/product")
    public ResponseEntity<ProductDto> addCategory(@ModelAttribute ProductDto productDto) throws IOException {
        ProductDto productDto1 = adminProduct.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllCategory() {
        List<ProductDto> productDtos = adminProduct.getAllProducts();
        return ResponseEntity.status(HttpStatus.CREATED).body(productDtos);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductsByName(@PathVariable String name) {
        List<ProductDto> productDtos = adminProduct.getAllProductsByName(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDtos);
    }

    @DeleteMapping("/product/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable Long id)  {
        boolean deleted = adminProduct.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
