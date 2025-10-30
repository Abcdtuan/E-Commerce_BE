package com.E_Commerce.Ecom.services.admin.user;

import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("adminUser")
@RequiredArgsConstructor
public class UserServiceIplm implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User toggleUserStatus(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User không tồn tại"));

        user.setActive(!user.isActive());
        return userRepository.save(user);
    }
}
