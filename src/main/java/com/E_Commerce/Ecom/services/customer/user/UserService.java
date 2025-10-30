package com.E_Commerce.Ecom.services.customer.user;

import com.E_Commerce.Ecom.dto.ChangePasswordRequest;
import com.E_Commerce.Ecom.dto.UserDto;

public interface UserService {

    UserDto getUserById(Long id);

    UserDto changePassword(ChangePasswordRequest request);
}
