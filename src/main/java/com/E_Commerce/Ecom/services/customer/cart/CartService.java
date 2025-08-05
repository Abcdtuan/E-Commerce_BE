package com.E_Commerce.Ecom.services.customer.cart;

import com.E_Commerce.Ecom.dto.AddProductInCartDto;
import com.E_Commerce.Ecom.dto.OrderDto;
import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<?> addProductsToCart(AddProductInCartDto addProductInCartDto);

    OrderDto getCartByUserId(Long userId);
}
