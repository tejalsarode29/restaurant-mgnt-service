package com.shantisagar.restaurant_mgnt_service.dtos;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String name;
}
