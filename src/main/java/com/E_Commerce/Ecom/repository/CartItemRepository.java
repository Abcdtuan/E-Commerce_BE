package com.E_Commerce.Ecom.repository;

import com.E_Commerce.Ecom.entity.CartItems;
import com.E_Commerce.Ecom.entity.Order;
import com.E_Commerce.Ecom.enums.OrderStatus;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CartItemRepository extends JpaRepository<CartItems,Long> {

    Optional<CartItems> findByProductIdAndUserIdAndOrderId(Long productId, Long userId, Long orderId);

}
