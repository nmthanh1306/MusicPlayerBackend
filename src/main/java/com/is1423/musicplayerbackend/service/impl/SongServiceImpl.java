package com.is1423.musicplayerbackend.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.is1423.musicplayerbackend.entity.MyFavouriteSong;
import com.is1423.musicplayerbackend.entity.PlayList;
import com.is1423.musicplayerbackend.entity.Song;
import com.is1423.musicplayerbackend.entity.User;
import com.is1423.musicplayerbackend.exception.EntityNameConstant;
import com.is1423.musicplayerbackend.exception.MessageKeyConstant;
import com.is1423.musicplayerbackend.exception.ResourceNotFoundException;
import com.is1423.musicplayerbackend.mapper.SongMapper;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;
import com.is1423.musicplayerbackend.repository.AlbumRepository;
import com.is1423.musicplayerbackend.repository.PlaylistRepository;
import com.is1423.musicplayerbackend.repository.SongFavouriteRepository;
import com.is1423.musicplayerbackend.repository.SongRepository;
import com.is1423.musicplayerbackend.repository.TypeRepository;
import com.is1423.musicplayerbackend.repository.UserRepository;
import com.is1423.musicplayerbackend.service.SongService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository repository;
    private final SongMapper mapper;
    private final PlaylistRepository playlistRepository;
    private final TypeRepository typeRepository;
    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    private final SongFavouriteRepository songFavouriteRepository;

    private static final int DEFAULT_INCREASE_FAVOURITE = 1;
    private static final Long DEFAULT_SONG_TYPE_ALBUM_PLAYLIST = 0l;
    private static final String RESULT = "result";

    @Override
    public List<SongResponseDTO> getListFavouriteSong(Long userId) {
        List<SongResponseDTO> listSong = mapper.toDtoList(repository.get5FavoriteSong());
        return updateSongIsFavourite(listSong, userId);
    }

    @Override
    public List<SongResponseDTO> getByPlayListId(Long playlistId, Long userId) {
        if (DEFAULT_SONG_TYPE_ALBUM_PLAYLIST.compareTo(playlistId) != 0) {
            playlistRepository.findById(playlistId)
                .orElseThrow(
                    () -> new ResourceNotFoundException(EntityNameConstant.PLAYLIST, MessageKeyConstant.NOT_FOUND, playlistId.toString()));
        }

        List<SongResponseDTO> listSong = mapper.toDtoList(repository.getByPlayListId(playlistId));
        return updateSongIsFavourite(listSong, userId);
    }

    @Override
    public List<SongResponseDTO> getByTypeId(Long typeId, Long userId) {
        if (DEFAULT_SONG_TYPE_ALBUM_PLAYLIST.compareTo(typeId) != 0) {
            typeRepository.findById(typeId)
                .orElseThrow(
                    () -> new ResourceNotFoundException(EntityNameConstant.TYPE, MessageKeyConstant.NOT_FOUND, typeId.toString()));
        }
        List<SongResponseDTO> listSong = mapper.toDtoList(repository.getByTypeId(typeId));
        return updateSongIsFavourite(listSong, userId);
    }

    @Override
    public List<SongResponseDTO> getByAlbumId(Long albumId, Long userId) {
        if (DEFAULT_SONG_TYPE_ALBUM_PLAYLIST.compareTo(albumId) != 0) {
            albumRepository.findById(albumId)
                .orElseThrow(
                    () -> new ResourceNotFoundException(EntityNameConstant.ALBUM, MessageKeyConstant.NOT_FOUND, albumId.toString()));
        }
        List<SongResponseDTO> listSong = mapper.toDtoList(repository.getByAlbumId(albumId));
        return updateSongIsFavourite(listSong, userId);
    }

    @Override
    public List<SongResponseDTO> getSongByNameOrAuthor(String text, Long userId) {
        List<SongResponseDTO> listSong;
        if (Objects.isNull(text) || text.length() == 0) {
            listSong = mapper.toDtoList(repository.findAll());
            return updateSongIsFavourite(listSong, userId);
        } else {
            listSong = mapper.toDtoList(repository.findBySongNameContains(text));
        }
        return updateSongIsFavourite(listSong, userId);

    }

    @Override
    public Map<String, Boolean> updateFavouriteSong(Long songId, Long userId) {
        Map<String, Boolean> result = new HashMap<>();
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        Song song = repository.findById(songId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND, songId.toString()));
        Optional<MyFavouriteSong> songFavourite = songFavouriteRepository.findByUserIdAndSongId(user.getId(), song.getSongId());

        // if song already exist => remove song favourite
        // else add song favourite
        if (songFavourite.isPresent()) {
            result.put(RESULT, Boolean.FALSE);
            songFavouriteRepository.delete(songFavourite.get());
            song.setFavourite(song.getFavourite() - DEFAULT_INCREASE_FAVOURITE);
        } else {
            result.put(RESULT, Boolean.TRUE);
            MyFavouriteSong newSongFavourite = new MyFavouriteSong(user.getId(), song.getSongId());
            songFavouriteRepository.save(newSongFavourite);
            song.setFavourite(song.getFavourite() + DEFAULT_INCREASE_FAVOURITE);
        }
        repository.save(song);
        return result;
    }


    @Override
    public Map<String, Boolean> updateUserPlayList(Long songId, Long playListId, Long userId) {
        Map<String, Boolean> result = new HashMap<>();
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        PlayList playList = playlistRepository.findPlayListByUserIdAndPlaylistId(user.getId(), playListId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.PLAYLIST, MessageKeyConstant.NOT_FOUND, playListId.toString()));
        Song song = repository.findById(songId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND, songId.toString()));

        if (!song.getPlaylistId().contains(playList.getPlaylistId().toString())) {
            result.put(RESULT, Boolean.TRUE);
            song.setPlaylistId(song.getPlaylistId() + "," + playList.getPlaylistId());
        } else {
            result.put(RESULT, Boolean.FALSE);
            song.setPlaylistId(song.getPlaylistId().replace("," + playList.getPlaylistId().toString(), ""));
        }
        repository.save(song);
        return result;
    }

    @Override
    public List<SongResponseDTO> getListSongFavourite(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        List<MyFavouriteSong> listSong = songFavouriteRepository.findAllByUserId(user.getId());

        if (CollectionUtils.isEmpty(listSong)) {
            return new ArrayList<>();
        } else {
            List<Long> songIds = listSong.stream().map(MyFavouriteSong::getSongId).collect(Collectors.toList());
            List<SongResponseDTO> listSongFavourite = mapper.toDtoList(repository.findAllById(songIds));
            listSongFavourite.forEach(song -> song.setUserFavourite(true));
            return listSongFavourite;
        }
    }

    /**
     * @param listSong
     * @param userId
     * @return Is song user favourite
     */
    private List<SongResponseDTO> updateSongIsFavourite(List<SongResponseDTO> listSong, Long userId) {
        if (Objects.isNull(userId)) {
            return listSong;
        }

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        List<Long> songIds = listSong.stream().map(SongResponseDTO::getSongId).collect(Collectors.toList());
        List<MyFavouriteSong> myFavouriteSongList = songFavouriteRepository.findAllBySongIdInAndUserId(songIds, user.getId());
        Map<Long, MyFavouriteSong> songMap = Objects.nonNull(myFavouriteSongList) ? myFavouriteSongList.stream()
            .collect(Collectors.toMap(MyFavouriteSong::getSongId, Function.identity())) : new HashMap<>();

        for (SongResponseDTO song : listSong) {
            if (Objects.nonNull(songMap.get(song.getSongId()))) {
                song.setUserFavourite(true);
            }
        }
        return listSong;
    }


}
