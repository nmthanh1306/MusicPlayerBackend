package com.is1423.musicplayerbackend.repository;

import com.is1423.musicplayerbackend.entity.Advertisement;
import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Query(value = "select new com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO" +
            "(ad.advertisementId, ad.songId, ad.advertisementImage, ad.advertisementContent,s.songName,s.singer, s.songImage) " +
           "from Advertisement ad join Song s on ad.songId = s.songId")
    List<AdvertisementResponseDTO> findAds();
}
