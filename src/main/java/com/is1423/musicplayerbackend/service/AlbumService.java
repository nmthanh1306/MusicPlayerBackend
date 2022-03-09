package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.AlbumResponseDTO;

public interface AlbumService {

    List<AlbumResponseDTO> getAlbumRandom();

    List<AlbumResponseDTO> getAll();

}
