package com.is1423.musicplayerbackend.mapper;

import org.mapstruct.Mapper;
import com.is1423.musicplayerbackend.entity.User;
import com.is1423.musicplayerbackend.model.response.UserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserResponseDTO, User> {

}
