package com.is1423.musicplayerbackend.mapper;

import com.is1423.musicplayerbackend.entity.Advertisement;
import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdvertisementResponseDTOMapper extends EntityMapper<AdvertisementResponseDTO,Advertisement> {

//    @Override
//    @Mapping(target = "advertisementId", source = "advertisementId")
//    @Mapping(target = "songId", source = "songId")
//    @Mapping(target = "advertisementImage", source = "advertisementImage")
//    @Mapping(target = "advertisementContent", source = "advertisementContent")

    AdvertisementResponseDTO toDto(Advertisement entity);
}
