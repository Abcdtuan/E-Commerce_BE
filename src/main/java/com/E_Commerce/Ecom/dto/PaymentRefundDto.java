package com.E_Commerce.Ecom.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentRefundDto {

    private Long id;

    private Long amountPaid;

    private Long amountRefunded;

    private String refundReason;


}
