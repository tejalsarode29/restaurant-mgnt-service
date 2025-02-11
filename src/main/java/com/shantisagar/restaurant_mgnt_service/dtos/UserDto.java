package com.shantisagar.restaurant_mgnt_service.dtos;

import com.shantisagar.restaurant_mgnt_service.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private UserRole userRole;
}
