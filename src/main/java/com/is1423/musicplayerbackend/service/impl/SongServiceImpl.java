package com.is1423.musicplayerbackend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.is1423.musicplayerbackend.entity.PlayList;
import com.is1423.musicplayerbackend.entity.Song;
import com.is1423.musicplayerbackend.entity.SongFavourite;
import com.is1423.musicplayerbackend.entity.User;
import com.is1423.musicplayerbackend.exception.BadRequestAlertException;
import com.is1423.musicplayerbackend.exception.EntityNameConstant;
import com.is1423.musicplayerbackend.exception.MessageKeyConstant;
import com.is1423.musicplayerbackend.exception.ResourceNotFoundException;
import com.is1423.musicplayerbackend.mapper.SongMapper;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;
import com.is1423.musicplayerbackend.repository.PlaylistRepository;
import com.is1423.musicplayerbackend.repository.SongFavouriteRepository;
import com.is1423.musicplayerbackend.repository.SongRepository;
import com.is1423.musicplayerbackend.repository.UserRepository;
import com.is1423.musicplayerbackend.service.SongService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository repository;
    private final SongMapper mapper;
    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final SongFavouriteRepository songFavouriteRepository;

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
    public void updateFavouriteSong(Long songId, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        Song song = repository.findById(songId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND, songId.toString()));
        Optional<SongFavourite> songFavourite = songFavouriteRepository.findByUserIdAndSongId(user.getId(), song.getSongId());

        // if song already exist => remove song favourite
        // else add song favourite
        if (songFavourite.isPresent()) {
            songFavouriteRepository.delete(songFavourite.get());
            song.setFavourite(song.getFavourite() - DEFAULT_INCREASE_FAVOURITE);
        } else {
            SongFavourite newSongFavourite = new SongFavourite(user.getId(), song.getSongId());
            songFavouriteRepository.save(newSongFavourite);
            song.setFavourite(song.getFavourite() + DEFAULT_INCREASE_FAVOURITE);
        }
        repository.save(song);
    }


    @Override
    public void addUserPlayList(Long songId, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        Optional<PlayList> playList = playlistRepository.findPlayListByUserId(user.getId());
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

    @Override
    public List<SongResponseDTO> removeSongFromPlayList(Long songId, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        Optional<PlayList> playList = playlistRepository.findPlayListByUserId(user.getId());
        Song song = repository.findById(songId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND, songId.toString()));

        if (!playList.isPresent()) {
            throw new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND_SONG_IN_PLAYLIST, songId.toString());
        } else {

            if (!song.getPlaylistId().contains(playList.get().getPlaylistId().toString())) {
                throw new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND_SONG_IN_PLAYLIST, songId.toString());
            }
            song.setPlaylistId(song.getPlaylistId().replace("," + playList.get().getPlaylistId().toString(), ""));
            repository.save(song);

        }

        return getByPlayListId(playList.get().getPlaylistId());
    }

    @Override
    public List<SongResponseDTO> getListSongFavourite(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        List<SongFavourite> listSong = songFavouriteRepository.findAllByUserId(user.getId());

        if (CollectionUtils.isEmpty(listSong)) {
            return new ArrayList<>();
        } else {
            List<Long> songIds = listSong.stream().map(SongFavourite::getSongId).collect(Collectors.toList());
            return mapper.toDtoList(repository.findAllById(songIds));
        }
    }

}
