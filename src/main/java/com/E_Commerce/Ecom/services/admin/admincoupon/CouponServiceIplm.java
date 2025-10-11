package com.E_Commerce.Ecom.services.admin.admincoupon;

import com.E_Commerce.Ecom.dto.CouponDto;
import com.E_Commerce.Ecom.entity.Coupon;
import com.E_Commerce.Ecom.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean deleteCoupon(Long id){
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);
        if(optionalCoupon.isPresent()){
            Coupon coupon = optionalCoupon.get();
            couponRepository.delete(coupon);
            return true;
        }
        return false;
    }

    @Override
    public CouponDto updateCoupon(Long id, CouponDto couponDto){
        Optional<Coupon> optionalCoupon = couponRepository.findById(id);
        if(optionalCoupon.isPresent()){
            Coupon coupon = optionalCoupon.get();
            coupon.setDiscount(couponDto.getDiscount());
            coupon.setExpirationDate(couponDto.getExpirationDate());
            coupon.setCode(couponDto.getCode());
            coupon.setName(couponDto.getName());

            Coupon updateCoupon = couponRepository.save(coupon);

            return new CouponDto(
                    updateCoupon.getId(),
                    updateCoupon.getName(),
                    updateCoupon.getCode(),
                    updateCoupon.getDiscount(),
                    updateCoupon.getExpirationDate()
            );
        }
        return null;
    }
}
