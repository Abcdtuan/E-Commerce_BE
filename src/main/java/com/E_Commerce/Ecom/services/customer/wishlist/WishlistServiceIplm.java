package com.E_Commerce.Ecom.services.customer.wishlist;

import com.E_Commerce.Ecom.dto.WishListDto;
import com.E_Commerce.Ecom.entity.Product;
import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.entity.Wishlist;
import com.E_Commerce.Ecom.repository.ProductRepository;
import com.E_Commerce.Ecom.repository.UserRepository;
import com.E_Commerce.Ecom.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistServiceIplm implements WishlistService {

    private final WishlistRepository wishlistRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;


    public WishListDto addProductToWishlist(WishListDto wishlistDto) {
        Optional<Product> productOptional = productRepository.findById(wishlistDto.getProductId());
        Optional<User> userOptional = userRepository.findById(wishlistDto.getUserId());

        if (productOptional.isPresent() && userOptional.isPresent()) {
            Wishlist wishlist = new Wishlist();
            wishlist.setProduct(productOptional.get());
            wishlist.setUser(userOptional.get());

            return wishlistRepository.save(wishlist).getWishlistDto();
        }
        return null;
    }

    public List<WishListDto> getWishlistByUserId(Long userId) {
        return wishlistRepository.findAllByUserId(userId).stream().map(Wishlist:: getWishlistDto).collect(Collectors.toList());
    }

    public boolean deleteWishlist(Long wishlistId) {
        Optional<Wishlist> optionalWishlist = wishlistRepository.findById(wishlistId);
        if (optionalWishlist.isPresent()) {
            Wishlist wishlist = optionalWishlist.get();
            wishlistRepository.delete(wishlist);
            return true;
        }
        return false;
    }


}
