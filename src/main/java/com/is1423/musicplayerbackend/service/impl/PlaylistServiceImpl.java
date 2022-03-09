package com.is1423.musicplayerbackend.service.impl;

import com.is1423.musicplayerbackend.mapper.PlaylistResponseDTOMapper;
import com.is1423.musicplayerbackend.model.response.PlaylistResponseDTO;
import com.is1423.musicplayerbackend.repository.PlaylistRepository;
import com.is1423.musicplayerbackend.service.PlaylistService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Data
@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistResponseDTOMapper mapper;
    private final PlaylistRepository repository;

    @Override
    public List<PlaylistResponseDTO> getPlaylistsWasRandom() {
        return mapper.toDtoList(repository.random3PlaylistPerOneDay());
    }

    @Override
    public List<PlaylistResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }
}
