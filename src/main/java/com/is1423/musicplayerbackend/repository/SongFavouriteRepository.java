package com.is1423.musicplayerbackend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.is1423.musicplayerbackend.entity.SongFavourite;

public interface SongFavouriteRepository extends JpaRepository<SongFavourite, Long> {

    List<SongFavourite> findAllByUserId(Long userId);

    Optional<SongFavourite> findByUserIdAndSongId(Long userId, Long songId);
}
