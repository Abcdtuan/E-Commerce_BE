package com.E_Commerce.Ecom.controller.admin;

import com.E_Commerce.Ecom.entity.User;
import com.E_Commerce.Ecom.services.admin.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/toggle-status/{id}")
    public ResponseEntity<User> toggleUserStatus(@PathVariable Long id) {
        User user = userService.toggleUserStatus(id);
        return ResponseEntity.ok(user);
    }
}
