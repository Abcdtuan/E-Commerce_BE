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

    @PostMapping("/coupon")
    public ResponseEntity<Coupon> createCoupon(@RequestBody CouponDto couponDto) {
        System.out.println("Ngày hết hạn nhận vào: " + couponDto.getExpirationDate());
        Coupon coupon = couponService.createCoupon(couponDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
    }
    @GetMapping("/coupons")
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        List<Coupon> coupons = couponService.getAllCoupons();
        return ResponseEntity.status(HttpStatus.OK).body(coupons);
    }

    @DeleteMapping("/coupon/delete/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
        boolean deleteCoupon = couponService.deleteCoupon(id);
        if (deleteCoupon) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/coupon/update/{id}")
    public ResponseEntity<CouponDto> updateCoupon(@PathVariable Long id, @RequestBody CouponDto couponDto) {
        CouponDto updatedCoupon = couponService.updateCoupon(id, couponDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCoupon);
    }

}
