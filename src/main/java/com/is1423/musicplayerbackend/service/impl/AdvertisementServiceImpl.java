package com.is1423.musicplayerbackend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.entity.Advertisement;
import com.is1423.musicplayerbackend.entity.Song;
import com.is1423.musicplayerbackend.exception.EntityNameConstant;
import com.is1423.musicplayerbackend.exception.ResourceNotFoundException;
import com.is1423.musicplayerbackend.mapper.SongMapper;
import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;
import com.is1423.musicplayerbackend.repository.AdvertisementRepository;
import com.is1423.musicplayerbackend.repository.SongRepository;
import com.is1423.musicplayerbackend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository repository;
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Override
    public List<AdvertisementResponseDTO> getAllAdvertisements() {
        return repository.findAds();
    }

    @Override
    public SongResponseDTO getSongByAdvertisement(Long advertisementId) {
        Advertisement advertisement = repository.findById(advertisementId)
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.ADVERTISEMENT, "Not Found", advertisementId.toString()));
        Song song = songRepository.findById(advertisement.getSongId())
            .orElseThrow(() -> new ResourceNotFoundException(EntityNameConstant.SONG, "Not Found", advertisement.getSongId().toString()));
        return songMapper.toDto(song);
    }
}
