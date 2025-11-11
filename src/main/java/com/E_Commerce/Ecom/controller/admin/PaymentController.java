package com.E_Commerce.Ecom.controller.admin;

import com.E_Commerce.Ecom.dto.PaymentDto;
import com.E_Commerce.Ecom.dto.PaymentRefundDto;
import com.E_Commerce.Ecom.services.admin.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("PaymentAdmin")
@RequiredArgsConstructor
@RequestMapping("/api/admin/")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<PaymentDto>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PutMapping("/payment/refund")
    public ResponseEntity<PaymentDto> refund(@RequestBody PaymentRefundDto paymentRefundDto) {
        PaymentDto paymentDto1 = paymentService.refund(paymentRefundDto);
        if(paymentDto1 != null) {
            return ResponseEntity.ok(paymentDto1);
        }
        return ResponseEntity.notFound().build();
    }
}
