package com.is1423.musicplayerbackend.repository;

import com.is1423.musicplayerbackend.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<PlayList, Long> {

    @Override
    List<PlayList> findAll();

    @Query(value = "select distinct * from playlist order by rand(CURRENT_DATE) limit 3",nativeQuery = true)
    List<PlayList> random3PlaylistPerOneDay();
}
