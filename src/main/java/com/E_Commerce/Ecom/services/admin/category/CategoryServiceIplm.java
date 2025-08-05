package com.E_Commerce.Ecom.services.admin.category;

import com.E_Commerce.Ecom.dto.CategoryDto;
import com.E_Commerce.Ecom.entity.Category;
import com.E_Commerce.Ecom.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceIplm implements CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
