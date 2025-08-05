package com.E_Commerce.Ecom.repository;

import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRole userRole);
}
