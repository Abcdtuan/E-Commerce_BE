package com.E_Commerce.Ecom.services.customer.brand;

import com.E_Commerce.Ecom.entity.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getByCategory(Long id);
}
