package com.E_Commerce.Ecom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VnpayConfig {

    @Value("${vnp_TmnCode}")
    public String vnp_TmnCode;

    @Value("${vnp_HashSecret}")
    public String vnp_HashSecret;

    @Value("${vnp_Url}")
    public String vnp_Url;

    @Value("${vnp_ReturnUrl}")
    public String vnp_ReturnUrl;
}
