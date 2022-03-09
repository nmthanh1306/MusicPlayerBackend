package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;

public interface SongService {

    List<SongResponseDTO> getListFavouriteSong();

    List<SongResponseDTO> getByPlayListId(Long playlistId);

}
