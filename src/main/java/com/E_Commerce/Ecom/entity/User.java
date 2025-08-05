package com.E_Commerce.Ecom.entity;

import com.E_Commerce.Ecom.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] image;


}
