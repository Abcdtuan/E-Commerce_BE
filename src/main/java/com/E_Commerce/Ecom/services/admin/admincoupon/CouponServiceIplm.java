package com.E_Commerce.Ecom.services.admin.admincoupon;

import com.E_Commerce.Ecom.dto.CouponDto;
import com.E_Commerce.Ecom.entity.Coupon;
import com.E_Commerce.Ecom.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceIplm implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public Coupon createCoupon(CouponDto couponDto){

        if(couponRepository.existsByCode(couponDto.getCode())) throw new RuntimeException("mã giảm giá đã tồn tại");
        Coupon coupon = new Coupon();
        coupon.setDiscount(couponDto.getDiscount());
        coupon.setExpirationDate(couponDto.getExpirationDate());
        coupon.setCode(couponDto.getCode());
        coupon.setName(couponDto.getName());

        return couponRepository.save(coupon);
    }

    @Override
    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }
}
