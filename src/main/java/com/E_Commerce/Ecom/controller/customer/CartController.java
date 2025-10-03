package com.E_Commerce.Ecom.controller.customer;

import com.E_Commerce.Ecom.dto.AddProductInCartDto;
import com.E_Commerce.Ecom.dto.CouponDto;
import com.E_Commerce.Ecom.dto.OrderDto;
import com.E_Commerce.Ecom.entity.Order;
import com.E_Commerce.Ecom.services.customer.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto) {
        return cartService.addProductsToCart(addProductInCartDto);
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long userId) {
        OrderDto orderDto = cartService.getCartByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @PostMapping("cart/coupon/{userId}/{couponId}")
    public ResponseEntity<OrderDto> applyCoupon (@PathVariable  Long userId, @PathVariable Long couponId){
        OrderDto orderDto = cartService.applyCoupon(userId, couponId);
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @PostMapping("/cart/addition")
    public ResponseEntity<OrderDto> increaseQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
        OrderDto orderDto = cartService.increaseQuantity(addProductInCartDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }

    @GetMapping("/cart/coupons")
    public ResponseEntity<List<CouponDto>> availableCoupons() {
        List<CouponDto> couponDtos = cartService.getAvailableCoupons();
        return ResponseEntity.status(HttpStatus.OK).body(couponDtos);
    }

    @PostMapping("/cart/deduction")
    public ResponseEntity<OrderDto> decreaseQuantity(@RequestBody AddProductInCartDto addProductInCartDto){
        OrderDto orderDto = cartService.decreaseQuantity(addProductInCartDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
    }

    @DeleteMapping("cart/deletion/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id){
        boolean deleted = cartService.deleteCartItem(id);
        if(deleted){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }



}
