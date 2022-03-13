package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;

public interface SongService {

    List<SongResponseDTO> getListFavouriteSong();

    List<SongResponseDTO> getByPlayListId(Long playlistId);

    List<SongResponseDTO> getByTypeId(Long typeId);

    List<SongResponseDTO> getByAlbumId(Long albumId);

    List<SongResponseDTO> getSongByNameOrAuthor(String name);

    SongResponseDTO updateFavouriteSong(Long songId);

    void addUserPlayList(Long songId, Long userId);

    List<SongResponseDTO> removeSongFromPlayList(Long songId, Long userId);





}
