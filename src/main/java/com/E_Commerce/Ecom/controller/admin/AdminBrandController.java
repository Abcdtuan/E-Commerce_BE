package com.E_Commerce.Ecom.controller.admin;

import com.E_Commerce.Ecom.dto.BrandDto;
import com.E_Commerce.Ecom.entity.Brand;
import com.E_Commerce.Ecom.repository.BrandRepository;
import com.E_Commerce.Ecom.services.admin.brand.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/brand")
public class AdminBrandController {

    private final BrandService brandService;


    @PostMapping("")
    public ResponseEntity<Brand> createBrand(@RequestBody BrandDto brandDto){
        Brand brand1 = brandService.createBrand(brandDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(brand1);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Brand>> getBrandByCategoryId(@PathVariable Long id){
        List<Brand> brands = brandService.getBrandByCategoryId(id);
        return ResponseEntity.ok(brands);
    }
}
