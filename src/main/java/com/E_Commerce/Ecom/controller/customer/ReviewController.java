package com.E_Commerce.Ecom.controller.customer;

import com.E_Commerce.Ecom.dto.OrderProductsResponseDto;
import com.E_Commerce.Ecom.dto.ReviewDto;
import com.E_Commerce.Ecom.services.customer.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderProductsResponseDto> getOrderProductsById(@PathVariable Long orderId) {
        return ResponseEntity.ok(reviewService.getOrderProductsById(orderId));
    }

    @PostMapping("/product")
    public ResponseEntity<ReviewDto> giveReview(@ModelAttribute ReviewDto reviewDto) throws Exception {
        ReviewDto review = reviewService.giveReview(reviewDto);
        if (review == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(review);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ReviewDto>> getAllReviewsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(reviewService.getAllReviewsByProductId(productId));
    }
}
