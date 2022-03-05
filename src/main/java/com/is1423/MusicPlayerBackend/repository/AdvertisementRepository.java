package com.is1423.MusicPlayerBackend.repository;

import com.is1423.MusicPlayerBackend.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Long> {

    @Override
    List<Advertisement> findAll();
}
