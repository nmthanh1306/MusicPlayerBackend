package com.is1423.musicplayerbackend.service.impl;

import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;
import com.is1423.musicplayerbackend.repository.AdvertisementRepository;
import com.is1423.musicplayerbackend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Data
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository repository;

    @Override
    public List<AdvertisementResponseDTO> getAllAdvertisements() {
        return repository.findAds();
        //return mapper.toDtoList(advertisementList);
    }
}
