package com.is1423.musicplayerbackend.repository;

import com.is1423.musicplayerbackend.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<PlayList, Long> {

    @Query(value = "select distinct * from Playlist where user_id = 1 order by rand(CURRENT_DATE) limit 3", nativeQuery = true)
    List<PlayList> random3PlaylistPerOneDay();

    Optional<PlayList> findPlayListByUserIdAndPlaylistId(Long userId, Long playListId);

    List<PlayList> findAllByUserId(Long userId);

    Optional<PlayList> findPlayListByPlayListNameAndUserId(String playListName, Long userId);


}
