package com.is1423.musicplayerbackend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.mapper.AlbumMapper;
import com.is1423.musicplayerbackend.model.response.AlbumResponseDTO;
import com.is1423.musicplayerbackend.repository.AlbumRepository;
import com.is1423.musicplayerbackend.service.AlbumService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository repository;
    private final AlbumMapper mapper;

    @Override
    public List<AlbumResponseDTO> getAlbumRandom() {
        return mapper.toDtoList(repository.random4AlbumPerOneDay());
    }

    @Override
    public List<AlbumResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }


}
