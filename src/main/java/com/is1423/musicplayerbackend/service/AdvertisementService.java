package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;

public interface AdvertisementService {

    List<AdvertisementResponseDTO> getAllAdvertisements();

    SongResponseDTO getSongByAdvertisement(Long advertisementId);
}
