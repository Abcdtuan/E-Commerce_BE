package com.E_Commerce.Ecom.controller.customer;

import com.E_Commerce.Ecom.dto.WishListDto;
import com.E_Commerce.Ecom.services.customer.wishlist.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer/wishlist")
public class WithlistController {

    private final WishlistService wishlistService;


    @PostMapping("")
    public ResponseEntity<WishListDto> addProductToWishlist(@RequestBody WishListDto wishlistDto) {
        WishListDto wishListDto = wishlistService.addProductToWishlist(wishlistDto);
        if (wishListDto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(wishListDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WishListDto>> getWishlistByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(wishlistService.getWishlistByUserId(userId));
    }
    @DeleteMapping("/deletion/{wishlistId}")
    public ResponseEntity<WishListDto> deleteWishlist(@PathVariable Long wishlistId) {
        boolean wishlistDeleted = wishlistService.deleteWishlist(wishlistId);
        if (wishlistDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
