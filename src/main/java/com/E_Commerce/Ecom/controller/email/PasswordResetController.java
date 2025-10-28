package com.E_Commerce.Ecom.controller.email;

import com.E_Commerce.Ecom.services.auth.PasswordResetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/password")
public class PasswordResetController {

    private final PasswordResetService passwordResetService;

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String email) {
        passwordResetService.sentOtp(email);
        return "OTP đã được gửi tới email: " + email;
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean verified = passwordResetService.verifyOtp(email, otp);
        return verified ? "OTP hợp lệ" : "OTP không hợp lệ";
    }
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email, @RequestParam String newPassword) {
        passwordResetService.resetPassword(email, newPassword);
        return "Đổi mật khẩu thành công";
    }
}
