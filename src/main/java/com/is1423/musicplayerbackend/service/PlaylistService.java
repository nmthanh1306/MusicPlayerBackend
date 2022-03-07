package com.is1423.musicplayerbackend.service;

import com.is1423.musicplayerbackend.model.response.PlaylistResponseDTO;

import java.util.List;

public interface PlaylistService {

    List<PlaylistResponseDTO> getPlaylistsWasRandom();

}
