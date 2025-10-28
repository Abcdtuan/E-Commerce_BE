package com.E_Commerce.Ecom.repository;

import com.E_Commerce.Ecom.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassWordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByEmail(String email);

    Optional<PasswordResetToken> findByEmailAndOpt(String email, String opt);
}
