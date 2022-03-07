package com.is1423.musicplayerbackend.mapper;

import org.mapstruct.Mapper;
import com.is1423.musicplayerbackend.entity.Album;
import com.is1423.musicplayerbackend.model.response.AlbumResponseDTO;

@Mapper(componentModel = "spring")
public interface AlbumMapper extends EntityMapper<AlbumResponseDTO, Album> {


}
