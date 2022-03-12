package com.is1423.musicplayerbackend.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.entity.User;
import com.is1423.musicplayerbackend.exception.BadCredentialsException;
import com.is1423.musicplayerbackend.exception.BadRequestAlertException;
import com.is1423.musicplayerbackend.exception.EntityNameConstant;
import com.is1423.musicplayerbackend.exception.MessageKeyConstant;
import com.is1423.musicplayerbackend.mapper.UserMapper;
import com.is1423.musicplayerbackend.model.response.UserDTO;
import com.is1423.musicplayerbackend.repository.UserRepository;
import com.is1423.musicplayerbackend.service.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private static final String DEFAULT_ROLE = "ROLE_USER";

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        Optional<User> user = repository.findUserByUserName(userDTO.getUserName());

        if (user.isPresent()) {
            throw new BadRequestAlertException(EntityNameConstant.USER, MessageKeyConstant.USER_ALREADY_EXIST, user.get().getUserName());
        }
        User newUser = mapper.toEntity(userDTO);
        newUser.setRole(DEFAULT_ROLE);
        return mapper.toDto(repository.save(newUser));
    }

    @Override
    public UserDTO login(UserDTO userDTO) {
        User user = repository.findUserByUserNameAndPassword(userDTO.getUserName(), userDTO.getPassword())
            .orElseThrow(() -> new BadCredentialsException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND,
                userDTO.getUserName() + " - " + userDTO.getPassword()));
        return mapper.toDto(user);
    }
}
