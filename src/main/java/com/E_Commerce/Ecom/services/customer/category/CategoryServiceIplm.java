package com.E_Commerce.Ecom.services.customer.category;

import com.E_Commerce.Ecom.entity.Category;
import com.E_Commerce.Ecom.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryCustomerService")
@RequiredArgsConstructor
public class CategoryServiceIplm implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
