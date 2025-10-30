package com.E_Commerce.Ecom.dto;

import lombok.Data;

@Data
public class ChangePasswordRequest {

    Long userId;

    String oldPassword;

    String newPassword;
}
