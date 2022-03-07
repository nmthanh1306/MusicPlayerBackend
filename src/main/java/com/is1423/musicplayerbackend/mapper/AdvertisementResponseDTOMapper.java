package com.is1423.musicplayerbackend.mapper;

import org.mapstruct.Mapper;
import com.is1423.musicplayerbackend.entity.Advertisement;
import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;

@Mapper(componentModel = "spring")
public interface AdvertisementResponseDTOMapper extends EntityMapper<AdvertisementResponseDTO, Advertisement> {


}
