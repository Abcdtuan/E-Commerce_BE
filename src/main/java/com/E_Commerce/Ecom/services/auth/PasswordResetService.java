package com.E_Commerce.Ecom.services.auth;

public interface PasswordResetService {

    void sentOtp(String email);

    boolean verifyOtp(String email, String otp);

    void resetPassword(String email, String newPassword);
}
