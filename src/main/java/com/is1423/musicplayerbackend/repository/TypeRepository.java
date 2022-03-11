package com.is1423.musicplayerbackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.is1423.musicplayerbackend.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query(value = "select distinct * from type order by rand(CURRENT_DATE) limit 4",nativeQuery = true)
    List<Type> random4TypePerOneDay();

    @Query(value = "SELECT * FROM type WHERE FIND_IN_SET(?1, theme_id)", nativeQuery = true)
    List<Type> findAllByThemeId(Long themeId);

}
