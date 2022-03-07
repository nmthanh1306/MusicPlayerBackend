package com.is1423.musicplayerbackend.repository;

import com.is1423.musicplayerbackend.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<PlayList, Long> {

    @Override
    List<PlayList> findAll();
}
