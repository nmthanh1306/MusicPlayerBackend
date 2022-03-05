package com.is1423.MusicPlayerBackend.service.impl;

import com.is1423.MusicPlayerBackend.entity.Advertisement;
import com.is1423.MusicPlayerBackend.model.response.AdvertisementResponseDto;
import com.is1423.MusicPlayerBackend.model.response.mapper.AdvertisementResponseDtoMapper;
import com.is1423.MusicPlayerBackend.repository.AdvertisementRepository;
import com.is1423.MusicPlayerBackend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Data
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementResponseDtoMapper mapper;
    private AdvertisementRepository repository;


    @Override
    public List<AdvertisementResponseDto> getAllAdvertisements() {
        List<Advertisement> advertisementList = repository.findAll();
        return mapper.toDtoList(advertisementList);
    }
}
