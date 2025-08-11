package com.E_Commerce.Ecom.services.admin.admincoupon;

import com.E_Commerce.Ecom.dto.CouponDto;
import com.E_Commerce.Ecom.entity.Coupon;

import java.util.List;

public interface CouponService {

    Coupon createCoupon(CouponDto couponDto);

    List<Coupon> getAllCoupons();
}
