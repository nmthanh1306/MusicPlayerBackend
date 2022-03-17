package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;

public interface SongService {

    List<SongResponseDTO> getListFavouriteSong(Long userId);

    List<SongResponseDTO> getByPlayListId(Long playlistId, Long userId);

    List<SongResponseDTO> getByTypeId(Long typeId, Long userId);

    List<SongResponseDTO> getByAlbumId(Long albumId, Long userId);

    List<SongResponseDTO> getSongByNameOrAuthor(String name, Long userId);

    void updateFavouriteSong(Long songId, Long userId);

    void addUserPlayList(Long songId, Long userId);

    List<SongResponseDTO> removeSongFromPlayList(Long songId, Long userId);

    List<SongResponseDTO> getListSongFavourite(Long userId);





}
