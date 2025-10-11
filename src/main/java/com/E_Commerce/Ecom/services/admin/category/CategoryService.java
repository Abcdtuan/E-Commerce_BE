package com.E_Commerce.Ecom.services.admin.category;

import com.E_Commerce.Ecom.dto.CategoryDto;
import com.E_Commerce.Ecom.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);

    List<Category> getAllCategories();

    CategoryDto updateCategory(Long id, CategoryDto categoryDto);

    boolean deleteCategory(Long id);
}
