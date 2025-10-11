package com.E_Commerce.Ecom.services.admin.category;

import com.E_Commerce.Ecom.dto.CategoryDto;
import com.E_Commerce.Ecom.entity.Category;
import com.E_Commerce.Ecom.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public CategoryDto updateCategory(Long id, CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());

             Category updatedCategory = categoryRepository.save(category);
             CategoryDto updatedCategoryDto = new CategoryDto();
             updatedCategoryDto.setId(updatedCategory.getId());
             updatedCategoryDto.setName(categoryDto.getName());
             updatedCategoryDto.setDescription(categoryDto.getDescription());
             return updatedCategoryDto;
        }
        return null;
    }

    public boolean deleteCategory(Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            categoryRepository.delete(category);
            return true;
        }
        return false;
    }

}
