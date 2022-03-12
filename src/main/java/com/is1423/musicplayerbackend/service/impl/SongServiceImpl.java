package com.is1423.musicplayerbackend.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.entity.PlayList;
import com.is1423.musicplayerbackend.entity.Song;
import com.is1423.musicplayerbackend.exception.BadRequestAlertException;
import com.is1423.musicplayerbackend.exception.EntityNameConstant;
import com.is1423.musicplayerbackend.exception.MessageKeyConstant;
import com.is1423.musicplayerbackend.exception.ResourceNotFoundException;
import com.is1423.musicplayerbackend.mapper.SongMapper;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;
import com.is1423.musicplayerbackend.repository.PlaylistRepository;
import com.is1423.musicplayerbackend.repository.SongRepository;
import com.is1423.musicplayerbackend.service.SongService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository repository;
    private final SongMapper mapper;
    private final PlaylistRepository playlistRepository;

    private static final int DEFAULT_INCREASE_FAVOURITE = 1;

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

    @Override
    public SongResponseDTO updateFavouriteSong(Long songId) {
        Song song = repository.findById(songId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND, songId.toString()));
        song.setFavourite(song.getFavourite() + DEFAULT_INCREASE_FAVOURITE);
        return mapper.toDto(repository.save(song));
    }

    @Override
    public void addUserPlayList(Long songId, Long userId) {
        Optional<PlayList> playList = playlistRepository.findPlayListByUserId(userId);
        Song song = repository.findById(songId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND, songId.toString()));
        if (playList.isPresent()) {
            PlayList myPlayList = playList.get();
            if (!song.getPlaylistId().contains(myPlayList.getPlaylistId().toString())) {
                song.setPlaylistId(song.getPlaylistId() + "," + myPlayList.getPlaylistId());
            } else {
                throw new BadRequestAlertException(EntityNameConstant.SONG, MessageKeyConstant.SONG_ALREADY_EXIST_IN_YOUR_PLAYLIST,
                    songId.toString());
            }
        } else {
            PlayList myPlayList = new PlayList(userId);
            myPlayList = playlistRepository.save(myPlayList);
            song.setPlaylistId(song.getPlaylistId() + "," + myPlayList.getPlaylistId());
        }
        repository.save(song);
    }

}
