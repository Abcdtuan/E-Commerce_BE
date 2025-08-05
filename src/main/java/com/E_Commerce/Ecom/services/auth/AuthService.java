package com.E_Commerce.Ecom.services.auth;

import com.E_Commerce.Ecom.dto.SignupRequest;
import com.E_Commerce.Ecom.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
