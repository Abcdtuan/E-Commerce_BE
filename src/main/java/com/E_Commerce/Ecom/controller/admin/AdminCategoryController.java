package com.E_Commerce.Ecom.controller.admin;
import com.E_Commerce.Ecom.dto.CategoryDto;
import com.E_Commerce.Ecom.entity.Category;
import com.E_Commerce.Ecom.repository.CategoryRepository;
import com.E_Commerce.Ecom.services.admin.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        Category  category = categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.CREATED).body(categories);
    }

    @PutMapping("/category/update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long id,@RequestBody CategoryDto categoryDto){
        CategoryDto updateDto = categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(updateDto);
    }
    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        boolean categoryDeleted = categoryService.deleteCategory(id);
        if(categoryDeleted){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
