package com.shantisagar.restaurant_mgnt_service.services.admin.rooms;

import org.springframework.stereotype.Service;

import com.shantisagar.restaurant_mgnt_service.dtos.Roomdto;
import com.shantisagar.restaurant_mgnt_service.entities.Room;
import com.shantisagar.restaurant_mgnt_service.repositories.RoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class RoomserviceImpl implements RoomServices {

    private final RoomRepository roomRepository;

    public boolean postRoom(Roomdto roomdto){
        try {
            Room room = new Room();
            room.setName(roomdto.getName());
            room.setPrice(roomdto.getPrice());
            room.setType(roomdto.getType());
            room.setAvailable(true);
            roomRepository.save(room);
            log.info("room save succefully");
            return true ; 
        } catch (Exception e) {
            log.error("Exception found while creating room");
            return false;
        }
    }

}
