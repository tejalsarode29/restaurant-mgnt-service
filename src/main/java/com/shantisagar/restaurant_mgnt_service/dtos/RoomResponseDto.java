package com.shantisagar.restaurant_mgnt_service.dtos;

import java.util.List;

import lombok.Data;

@Data
public class RoomResponseDto {
    private List<Roomdto> roomdto;

    private Integer totalpages;
    
    private Integer pageNumber;

}
