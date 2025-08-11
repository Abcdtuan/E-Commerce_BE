package com.E_Commerce.Ecom.controller.admin;

import com.E_Commerce.Ecom.dto.CouponDto;
import com.E_Commerce.Ecom.entity.Coupon;
import com.E_Commerce.Ecom.services.admin.admincoupon.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin")
public class AdminCouponController {

    private final CouponService couponService;

    @PostMapping("coupon")
    public ResponseEntity<Coupon> createCoupon(@RequestBody CouponDto couponDto) {
        System.out.println("Ngày hết hạn nhận vào: " + couponDto.getExpirationDate());
        Coupon coupon = couponService.createCoupon(couponDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }
    @GetMapping("coupons")
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        List<Coupon> coupons = couponService.getAllCoupons();
        return ResponseEntity.status(HttpStatus.OK).body(coupons);
    }

}
