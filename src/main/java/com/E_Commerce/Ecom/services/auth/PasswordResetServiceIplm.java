package com.E_Commerce.Ecom.services.auth;

import com.E_Commerce.Ecom.entity.PasswordResetToken;
import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.repository.PassWordResetTokenRepository;
import com.E_Commerce.Ecom.repository.UserRepository;
import com.E_Commerce.Ecom.services.mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PasswordResetServiceIplm implements PasswordResetService {

    private final UserRepository userRepository;

    private final PassWordResetTokenRepository tokenRepository;

    private final MailService mailService;

    public void sentOtp(String email) {
        User user = userRepository.findFirstByEmail(email).orElseThrow(()->new RuntimeException("Email không tồn tại"));

        String otp = String.format("%06d", new Random().nextInt(999999));

        PasswordResetToken token = tokenRepository.findByEmail(email).orElse(new PasswordResetToken());

        token.setEmail(email);
        token.setOpt(otp);
        token.setExpiryDate(LocalDateTime.now().plusMinutes(5));
        token.setVerified(false);

        tokenRepository.save(token);
        mailService.sendOtpEmail(email, otp);
    }

    public boolean verifyOtp(String email, String otp) {
        PasswordResetToken token = tokenRepository.findByEmailAndOpt(email, otp)
                .orElseThrow(() -> new RuntimeException("OTP không hợp lệ"));

        if(token.getExpiryDate().isBefore(LocalDateTime.now())){
            throw new RuntimeException("OTP đã hết hạn");
        }
        token.setVerified(true);
        tokenRepository.save(token);
        return true;
    }

    public void resetPassword(String email, String newPassword) {
        PasswordResetToken token = tokenRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Chưa xác thực OTP"));
        if (!token.isVerified()){
            throw new RuntimeException("OTP chưa xác thực");
        }
        User user = userRepository.findFirstByEmail(email).get();
        user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        userRepository.save(user);

        tokenRepository.delete(token);

    }
}
