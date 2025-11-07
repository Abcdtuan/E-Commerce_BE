package com.E_Commerce.Ecom.services.customer.brand;

import com.E_Commerce.Ecom.entity.Brand;
import com.E_Commerce.Ecom.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("BrandCustomerService")
@RequiredArgsConstructor
public class BrandServiceIplm implements BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> getByCategory(Long id){
        List<Brand> brands = brandRepository.findByCategoryId(id);
        if(brands != null){
            return brands;
        }
        return null;
    }
}
