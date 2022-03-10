package com.is1423.musicplayerbackend.service.impl;

import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.mapper.SongMapper;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;
import com.is1423.musicplayerbackend.repository.SongRepository;
import com.is1423.musicplayerbackend.service.SongService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository repository;
    private final SongMapper mapper;

    @Override
    public List<SongResponseDTO> getListFavouriteSong() {
        return mapper.toDtoList(repository.get5FavoriteSong());
    }

    @Override
    public List<SongResponseDTO> getByPlayListId(Long playlistId) {
        return mapper.toDtoList(repository.getByPlayListId(playlistId));
    }

    @Override
    public List<SongResponseDTO> getByTypeId(Long typeId) {
        return mapper.toDtoList(repository.getByTypeId(typeId));
    }

    @Override
    public List<SongResponseDTO> getByAlbumId(Long albumId) {
        return mapper.toDtoList(repository.getByAlbumId(albumId));
    }

    @Override
    public List<SongResponseDTO> getSongByNameOrAuthor(String text) {
        if (Objects.isNull(text) || text.length() == 0) {
            return mapper.toDtoList(repository.findAll());
        }
        return mapper.toDtoList(repository.findBySongNameContains(text));
    }

}
