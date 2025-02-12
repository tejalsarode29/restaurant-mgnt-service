package com.shantisagar.restaurant_mgnt_service.services.admin.rooms;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shantisagar.restaurant_mgnt_service.dtos.RoomResponseDto;
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

    public boolean postRoom(Roomdto roomdto) {
        try {
            Room room = new Room();
            room.setName(roomdto.getName());
            room.setPrice(roomdto.getPrice());
            room.setType(roomdto.getType());
            room.setAvailable(true);
            roomRepository.save(room);
            log.info("room save succefully");
            return true;
        } catch (Exception e) {
            log.error("Exception found while creating room");
            return false;
        }
    }

    public RoomResponseDto getAllRooms(int pageNmber) {
        Pageable pageable = PageRequest.of(pageNmber, 6);
        Page<Room> roomPage = roomRepository.findAll(pageable);
        RoomResponseDto roomResponseDto = new RoomResponseDto();
        roomResponseDto.setPageNumber(roomPage.getPageable().getPageNumber());
        roomResponseDto.setTotalpages(roomPage.getTotalPages());
        roomResponseDto.setRoomdto(roomPage.stream().map(Room::geRoomdto).collect(Collectors.toList()));
        return roomResponseDto;

    }

}
