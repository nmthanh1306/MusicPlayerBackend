package com.is1423.musicplayerbackend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.mapper.MusicThemeMapper;
import com.is1423.musicplayerbackend.model.response.MusicThemeResponseDTO;
import com.is1423.musicplayerbackend.repository.MusicThemeRepository;
import com.is1423.musicplayerbackend.service.MusicThemeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MusicThemeServiceImpl implements MusicThemeService {


    private final MusicThemeRepository repository;
    private final MusicThemeMapper mapper;

    @Override
    public List<MusicThemeResponseDTO> getMusicThemeRandom() {
        return mapper.toDtoList(repository.random4MusicThemePerOneDay());
    }

    @Override
    public List<MusicThemeResponseDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }


}
