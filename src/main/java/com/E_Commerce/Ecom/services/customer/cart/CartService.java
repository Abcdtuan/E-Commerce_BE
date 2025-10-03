package com.E_Commerce.Ecom.services.customer.cart;

import com.E_Commerce.Ecom.dto.AddProductInCartDto;
import com.E_Commerce.Ecom.dto.CouponDto;
import com.E_Commerce.Ecom.dto.OrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {

    ResponseEntity<?> addProductsToCart(AddProductInCartDto addProductInCartDto);

    OrderDto getCartByUserId(Long userId);

    OrderDto applyCoupon(Long userId, Long couponId);

    List<CouponDto> getAvailableCoupons();

    OrderDto increaseQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto decreaseQuantity(AddProductInCartDto addProductInCartDto);

    boolean deleteCartItem(Long id);
}
