package com.E_Commerce.Ecom.controller.customer;

import com.E_Commerce.Ecom.entity.Brand;
import com.E_Commerce.Ecom.services.customer.brand.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer/brand")
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Brand>> getByCategoryId(@PathVariable Long categoryId) {
        List<Brand> brands = brandService.getByCategory(categoryId);
        if(brands !=  null){
            return ResponseEntity.ok(brands);
        }
        return ResponseEntity.notFound().build();
    }


}
