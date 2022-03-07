package com.is1423.musicplayerbackend.service;

import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;

import java.util.List;

public interface AdvertisementService {

    List<AdvertisementResponseDTO> getAllAdvertisements();
}
