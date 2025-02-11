package com.shantisagar.restaurant_mgnt_service.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Roomdto {
   
    private Long id;

    private String name;
    private String type;
    private Long price;
    private boolean available;
    
}
