package com.E_Commerce.Ecom.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
public class CouponDto {

    private Long id;

    private String name;

    private String code;

    private Long discount;


    private Date expirationDate;
}
