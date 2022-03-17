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
    public List<SongResponseDTO> getListFavouriteSong(Long userId) {
        List<SongResponseDTO> listSong = mapper.toDtoList(repository.get5FavoriteSong());
        return updateSongIsFavourite(listSong, userId);
    }

    @Override
    public List<SongResponseDTO> getByPlayListId(Long playlistId, Long userId) {
        List<SongResponseDTO> listSong = mapper.toDtoList(repository.getByPlayListId(playlistId));
        return updateSongIsFavourite(listSong, userId);
    }

    @Override
    public List<SongResponseDTO> getByTypeId(Long typeId, Long userId) {
        List<SongResponseDTO> listSong = mapper.toDtoList(repository.getByTypeId(typeId));
        return updateSongIsFavourite(listSong, userId);
    }

    @Override
    public List<SongResponseDTO> getByAlbumId(Long albumId, Long userId) {
        List<SongResponseDTO> listSong = mapper.toDtoList(repository.getByAlbumId(albumId));
        return updateSongIsFavourite(listSong, userId);
    }

    @Override
    public List<SongResponseDTO> getSongByNameOrAuthor(String text, Long userId) {
        List<SongResponseDTO> listSong = new ArrayList<>();
        if (Objects.isNull(text) || text.length() == 0) {
            listSong = mapper.toDtoList(repository.findAll());
            return updateSongIsFavourite(listSong, userId);
        } else {
            listSong = mapper.toDtoList(repository.findBySongNameContains(text));
        }
        return updateSongIsFavourite(listSong, userId);

    }

    @Override
    public void updateFavouriteSong(Long songId, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.USER, MessageKeyConstant.NOT_FOUND, userId.toString()));
        Song song = repository.findById(songId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.SONG, MessageKeyConstant.NOT_FOUND, songId.toString()));
        Optional<MyFavouriteSong> songFavourite = songFavouriteRepository.findByUserIdAndSongId(user.getId(), song.getSongId());

        // if song already exist => remove song favourite
        // else add song favourite
        if (songFavourite.isPresent()) {
            songFavouriteRepository.delete(songFavourite.get());
            song.setFavourite(song.getFavourite() - DEFAULT_INCREASE_FAVOURITE);
        } else {
            MyFavouriteSong newSongFavourite = new MyFavouriteSong(user.getId(), song.getSongId());
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

        return getByPlayListId(playList.get().getPlaylistId(), user.getId());
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
