package com.E_Commerce.Ecom.entity;

import com.E_Commerce.Ecom.dto.WishListDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "wishlist")
public class Wishlist {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public WishListDto getWishlistDto () {
        WishListDto wishlistDto = new WishListDto();
        wishlistDto.setId(id);
        wishlistDto.setProductId(product.getId());
        wishlistDto.setReturnedImage(product.getImages().get(0).getImg());
        wishlistDto.setProductName(product.getName());
        wishlistDto.setPrice(product.getPrice());
        wishlistDto.setUserId(user.getId());

        return wishlistDto;
    }
}
