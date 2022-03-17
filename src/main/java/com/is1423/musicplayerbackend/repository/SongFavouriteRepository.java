package com.is1423.musicplayerbackend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.is1423.musicplayerbackend.entity.MyFavouriteSong;

public interface SongFavouriteRepository extends JpaRepository<MyFavouriteSong, Long> {

    List<MyFavouriteSong> findAllByUserId(Long userId);

    Optional<MyFavouriteSong> findByUserIdAndSongId(Long userId, Long songId);

    List<MyFavouriteSong> findAllBySongIdInAndUserId(List<Long> songIds, Long userId);
}
