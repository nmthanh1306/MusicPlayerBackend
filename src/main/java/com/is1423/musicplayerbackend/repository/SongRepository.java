package com.is1423.musicplayerbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.is1423.musicplayerbackend.entity.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = "SELECT  * FROM song ORDER BY favourite DESC LIMIT 5",nativeQuery = true)
    List<Song> get5FavoriteSong();


    @Query(value = "SELECT  * FROM song WHERE FIND_IN_SET(?1, playlist_id)",nativeQuery = true)
    List<Song> getByIdPlayList(Long playListId);

}
