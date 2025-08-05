package com.E_Commerce.Ecom.repository;

import com.E_Commerce.Ecom.entity.Order;
import com.E_Commerce.Ecom.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);





}
