package com.shantisagar.restaurant_mgnt_service.Mapper;

import com.shantisagar.restaurant_mgnt_service.dtos.UserDto;
import com.shantisagar.restaurant_mgnt_service.entities.User;

public class UserMapper {

//entity to dto

   //dto to entity
   public static User mapTOEntity(UserDto userDto){
        return new User(userDto.getId(),userDto.getEmail(),userDto.getName(),userDto.getUserRole());
   }

   //entity to dto
   public static UserDto mapToDto(User user){
    return new UserDto(user.getId(), user.getEmail(), user.getName(), user.getUserRole());
   }



}
