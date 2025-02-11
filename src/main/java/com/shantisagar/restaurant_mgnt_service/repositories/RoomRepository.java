package com.shantisagar.restaurant_mgnt_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shantisagar.restaurant_mgnt_service.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    
}
