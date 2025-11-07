package com.E_Commerce.Ecom.services.admin.brand;

import com.E_Commerce.Ecom.dto.BrandDto;
import com.E_Commerce.Ecom.entity.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {

    Brand createBrand(BrandDto brandDto);

    List<Brand> getAllBrands();

    boolean deleteCategory(Long id);

    List<Brand> getBrandByCategoryId(Long id);
}
