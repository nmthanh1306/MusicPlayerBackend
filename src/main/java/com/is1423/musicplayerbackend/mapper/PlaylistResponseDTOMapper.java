package com.is1423.musicplayerbackend.mapper;

import com.is1423.musicplayerbackend.entity.PlayList;
import com.is1423.musicplayerbackend.model.response.PlaylistResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaylistResponseDTOMapper extends EntityMapper<PlaylistResponseDTO, PlayList>{

    PlaylistResponseDTO toDto(PlayList entity);
}
