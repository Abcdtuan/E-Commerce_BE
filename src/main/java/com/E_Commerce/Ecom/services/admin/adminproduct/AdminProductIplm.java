package com.E_Commerce.Ecom.services.admin.adminproduct;

import com.E_Commerce.Ecom.dto.ProductDto;
import com.E_Commerce.Ecom.entity.Category;
import com.E_Commerce.Ecom.entity.Product;
import com.E_Commerce.Ecom.repository.CategoryRepository;
import com.E_Commerce.Ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminProductIplm implements AdminProduct {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductDto addProduct(ProductDto productDto) throws IOException {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImg(productDto.getImg().getBytes());


        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow();

        product.setCategory(category);

        return productRepository.save(product).getDto();

    }

    public List<ProductDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductsByName(String name){
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
    public boolean deleteProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ProductDto getProductById(Long id) {
       Optional<Product> product = productRepository.findById(id);
       if(product.isPresent()){
           return product.get().getDto();
       }else{
           return null;
       }
    }
    public ProductDto updateProduct(Long id, ProductDto productDto) throws IOException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if(optionalProduct.isPresent() && optionalCategory.isPresent()){
            Product product = optionalProduct.get();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setCategory(optionalCategory.get());
            if(productDto.getImg() != null){
                product.setImg(productDto.getImg().getBytes());
            }
            return productRepository.save(product).getDto();
            
        }
        return null;
    }

}
