package com.shantisagar.restaurant_mgnt_service.Controllers.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shantisagar.restaurant_mgnt_service.dtos.Roomdto;
import com.shantisagar.restaurant_mgnt_service.services.admin.rooms.RoomServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class RoomController {

    private final RoomServices roomServices;

    @PostMapping
    public ResponseEntity<Roomdto> createRoom(@RequestBody Roomdto roomdto) {
        boolean success = roomServices.postRoom(roomdto);
        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build();

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/rooms/{pagenumber}")
    public ResponseEntity<?> getAllrooms(@PathVariable (value = "pagenumber") int pageNumber ){
        return ResponseEntity.ok(roomServices.getAllRooms(pageNumber));
    }

}
