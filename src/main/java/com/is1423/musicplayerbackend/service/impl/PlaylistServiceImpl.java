package com.is1423.musicplayerbackend.service.impl;

import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.entity.User;
import com.is1423.musicplayerbackend.exception.EntityNameConstant;
import com.is1423.musicplayerbackend.exception.MessageKeyConstant;
import com.is1423.musicplayerbackend.exception.ResourceNotFoundException;
import com.is1423.musicplayerbackend.mapper.PlaylistResponseDTOMapper;
import com.is1423.musicplayerbackend.model.response.PlaylistResponseDTO;
import com.is1423.musicplayerbackend.repository.PlaylistRepository;
import com.is1423.musicplayerbackend.repository.UserRepository;
import com.is1423.musicplayerbackend.service.PlaylistService;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistResponseDTOMapper mapper;
    private final PlaylistRepository repository;
    private final UserRepository userRepository;

    private static final long ADMIN_ID = 1l;

    @Override
    public List<PlaylistResponseDTO> getPlaylistsWasRandom() {
        return mapper.toDtoList(repository.random3PlaylistPerOneDay());
    }

    @Override
    public List<PlaylistResponseDTO> getAll(Long userId) {
        if (Objects.isNull(userId)) {
            return mapper.toDtoList(repository.findAllByUserId(ADMIN_ID));
        }
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        return mapper.toDtoList(repository.findAllByUserId(user.getId()));
    }
}
