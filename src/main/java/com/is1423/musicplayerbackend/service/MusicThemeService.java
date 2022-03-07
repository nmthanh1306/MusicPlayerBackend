package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.MusicThemeResponseDTO;

public interface MusicThemeService {

    List<MusicThemeResponseDTO> getMusicThemeRandom();
}
