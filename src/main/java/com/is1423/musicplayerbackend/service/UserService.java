package com.is1423.musicplayerbackend.service;

import com.is1423.musicplayerbackend.model.response.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserResponseDTO userResponseDTO);

    UserResponseDTO login(UserResponseDTO userResponseDTO);


}
