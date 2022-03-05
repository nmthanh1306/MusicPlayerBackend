package com.is1423.MusicPlayerBackend.service;

import com.is1423.MusicPlayerBackend.model.response.AdvertisementResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdvertisementService {

    List<AdvertisementResponseDto> getAllAdvertisements();
}
