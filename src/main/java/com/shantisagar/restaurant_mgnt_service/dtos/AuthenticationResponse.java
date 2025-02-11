package com.shantisagar.restaurant_mgnt_service.dtos;

import com.shantisagar.restaurant_mgnt_service.enums.UserRole;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private Long userid;
    private UserRole userRole;
    
}
