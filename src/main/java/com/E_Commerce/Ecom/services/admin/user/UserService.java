package com.E_Commerce.Ecom.services.admin.user;

import com.E_Commerce.Ecom.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User toggleUserStatus(Long userId);

}
