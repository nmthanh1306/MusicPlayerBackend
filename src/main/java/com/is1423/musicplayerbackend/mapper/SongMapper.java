package com.is1423.musicplayerbackend.mapper;

import org.mapstruct.Mapper;
import com.is1423.musicplayerbackend.entity.Song;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;

@Mapper(componentModel = "spring")
public interface SongMapper extends EntityMapper<SongResponseDTO, Song> {

}
