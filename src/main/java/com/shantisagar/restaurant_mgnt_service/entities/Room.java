package com.shantisagar.restaurant_mgnt_service.entities;

import com.shantisagar.restaurant_mgnt_service.dtos.Roomdto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Long price;
    private boolean available;
    public Roomdto geRoomdto(){
        Roomdto roomdto = new Roomdto();
        roomdto.setId(id);
        roomdto.setName(name);
        roomdto.setType(type);
        roomdto.setAvailable(available);
        roomdto.setPrice(price);
        return roomdto;
    }


    
    
}
