package com.shantisagar.restaurant_mgnt_service.services.admin.rooms;

import com.shantisagar.restaurant_mgnt_service.dtos.RoomResponseDto;
import com.shantisagar.restaurant_mgnt_service.dtos.Roomdto;

public interface RoomServices {
    boolean postRoom(Roomdto roomdto);
    RoomResponseDto getAllRooms(int pageNmber);
    
}
