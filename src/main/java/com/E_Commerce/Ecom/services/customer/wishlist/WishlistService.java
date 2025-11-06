package com.E_Commerce.Ecom.services.customer.wishlist;

import com.E_Commerce.Ecom.dto.WishListDto;

import java.util.List;

public interface WishlistService {

    WishListDto addProductToWishlist(WishListDto wishlistDto);

    List<WishListDto> getWishlistByUserId(Long userId);

    boolean deleteWishlist(Long wishlistId);
}
