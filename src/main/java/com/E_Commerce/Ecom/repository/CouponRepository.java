package com.E_Commerce.Ecom.repository;

import com.E_Commerce.Ecom.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    boolean existsByCode(String code);

    Optional<Coupon> findCouponByCode(String code);

    List<Coupon> code(String code);
}
