package com.is1423.musicplayerbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.is1423.musicplayerbackend.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query(value = "select distinct * from album order by rand(CURRENT_DATE) limit 4",nativeQuery = true)
    List<Album> random4AlbumPerOneDay();

}
