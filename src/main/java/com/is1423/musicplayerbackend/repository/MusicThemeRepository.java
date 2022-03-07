package com.is1423.musicplayerbackend.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.is1423.musicplayerbackend.entity.MusicTheme;

@Repository
public interface MusicThemeRepository extends JpaRepository<MusicTheme, Long> {

    @Query(value = "select distinct * from music_theme order by rand(CURRENT_DATE) limit 4",nativeQuery = true)
    List<MusicTheme> random4MusicThemePerOneDay();

    @Override
    Optional<MusicTheme> findById(Long id);
}
