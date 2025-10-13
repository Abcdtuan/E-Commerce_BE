package com.E_Commerce.Ecom.controller;

import com.E_Commerce.Ecom.services.payment.PaymentServiceIplm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentServiceIplm paymentService;
    public PaymentController(PaymentServiceIplm paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Map<String, String> createPayment(@RequestBody Map<String, Object> req) throws Exception {
        Long amount = Long.parseLong(req.get("amount").toString());
        String orderInfo = req.get("orderInfo").toString();
        String ipAddr = "127.0.0.1";

        String paymentUrl = paymentService.createPaymentUrl(amount, orderInfo, ipAddr);
        Map<String, String> res = new HashMap<>();
        res.put("url", paymentUrl);
        return res;
    }
}
