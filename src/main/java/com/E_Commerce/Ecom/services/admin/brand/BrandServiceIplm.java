package com.E_Commerce.Ecom.services.admin.brand;

import com.E_Commerce.Ecom.dto.BrandDto;
import com.E_Commerce.Ecom.entity.Brand;
import com.E_Commerce.Ecom.entity.Category;
import com.E_Commerce.Ecom.repository.BrandRepository;
import com.E_Commerce.Ecom.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BrandServiceIplm implements BrandService {

    private final BrandRepository brandRepository;

    private final CategoryRepository categoryRepository;

    public Brand createBrand(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        brand.setDescription(brandDto.getDescription());
        Category category = categoryRepository.findById(brandDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        brand.setCategory(category);
        return brandRepository.save(brand);
    }

    public List<Brand> getAllBrands(){
        List<Brand> brands = brandRepository.findAll();
        return brands;
    }

    public boolean deleteCategory(Long id){
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if(optionalBrand.isPresent()){
            Brand brand = optionalBrand.get();
            brandRepository.delete(brand);
            return true;
        }
        return false;
    }

    public List<Brand> getBrandByCategoryId(Long id){
       return brandRepository.findByCategoryId(id);
    }
}
