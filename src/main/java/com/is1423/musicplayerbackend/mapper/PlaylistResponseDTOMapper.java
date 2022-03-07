package com.is1423.musicplayerbackend.mapper;

import org.mapstruct.Mapper;
import com.is1423.musicplayerbackend.entity.PlayList;
import com.is1423.musicplayerbackend.model.response.PlaylistResponseDTO;

@Mapper(componentModel = "spring")
public interface PlaylistResponseDTOMapper extends EntityMapper<PlaylistResponseDTO, PlayList> {


}
