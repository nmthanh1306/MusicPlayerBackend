package com.is1423.musicplayerbackend.service;

import com.is1423.musicplayerbackend.model.response.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO login(UserDTO userDTO);


}
