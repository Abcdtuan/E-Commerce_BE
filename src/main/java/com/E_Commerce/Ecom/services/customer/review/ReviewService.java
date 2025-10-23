package com.E_Commerce.Ecom.services.customer.review;

import com.E_Commerce.Ecom.dto.OrderProductsResponseDto;
import com.E_Commerce.Ecom.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    OrderProductsResponseDto getOrderProductsById(Long orderId);

    ReviewDto giveReview(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> getAllReviewsByProductId(Long productId);
}
