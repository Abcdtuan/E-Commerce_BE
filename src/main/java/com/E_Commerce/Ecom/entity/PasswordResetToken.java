package com.E_Commerce.Ecom.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "password_reset")
public class PasswordResetToken {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String email;

    private String opt;

    private LocalDateTime expiryDate;

    private boolean verified;
}
