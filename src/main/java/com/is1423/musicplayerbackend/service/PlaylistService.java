package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.PlaylistResponseDTO;

public interface PlaylistService {

    List<PlaylistResponseDTO> getPlaylistsWasRandom();

    List<PlaylistResponseDTO> getAll(Long userID);

    PlaylistResponseDTO create(PlaylistResponseDTO playlistResponseDTO, Long userId);

    PlaylistResponseDTO update(PlaylistResponseDTO playlistResponseDTO, Long userId);

    void delete(Long playListId, Long userId);
}
