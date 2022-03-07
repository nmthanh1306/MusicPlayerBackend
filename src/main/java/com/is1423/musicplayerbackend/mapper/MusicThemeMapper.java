package com.is1423.musicplayerbackend.mapper;

import org.mapstruct.Mapper;
import com.is1423.musicplayerbackend.entity.MusicTheme;
import com.is1423.musicplayerbackend.model.response.MusicThemeResponseDTO;

@Mapper(componentModel = "spring")
public interface MusicThemeMapper extends EntityMapper<MusicThemeResponseDTO, MusicTheme> {

}
