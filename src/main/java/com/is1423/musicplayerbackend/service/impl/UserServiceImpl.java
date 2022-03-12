package com.is1423.musicplayerbackend.service.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.entity.User;
import com.is1423.musicplayerbackend.exception.BadCredentialsException;
import com.is1423.musicplayerbackend.exception.BadRequestAlertException;
import com.is1423.musicplayerbackend.exception.EntityNameConstant;
import com.is1423.musicplayerbackend.exception.MessageKeyConstant;
import com.is1423.musicplayerbackend.mapper.UserMapper;
import com.is1423.musicplayerbackend.model.response.UserResponseDTO;
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
    public UserResponseDTO createUser(UserResponseDTO userResponseDTO) {

        Optional<User> user = repository.findUserByUserName(userResponseDTO.getUserName());

        if (user.isPresent()) {
            throw new BadRequestAlertException(EntityNameConstant.USER, MessageKeyConstant.USER_ALREADY_EXIST, user.get().getUserName());
        }
        User newUser = mapper.toEntity(userResponseDTO);
        newUser.setRole(DEFAULT_ROLE);
        return mapper.toDto(repository.save(newUser));
    }

    @Override
    public UserResponseDTO login(UserResponseDTO userResponseDTO) {
        User user = repository.findUserByUserNameAndPassword(userResponseDTO.getUserName(), userResponseDTO.getPassword())
            .orElseThrow(() -> new BadCredentialsException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND,
                userResponseDTO.getUserName() + " - " + userResponseDTO.getPassword()));
        return mapper.toDto(user);
    }
}
