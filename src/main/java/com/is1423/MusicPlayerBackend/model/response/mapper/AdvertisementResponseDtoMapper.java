package com.is1423.MusicPlayerBackend.model.response.mapper;

import com.is1423.MusicPlayerBackend.entity.Advertisement;
import com.is1423.MusicPlayerBackend.model.EntityMapper;
import com.is1423.MusicPlayerBackend.model.response.AdvertisementResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdvertisementResponseDtoMapper extends EntityMapper<AdvertisementResponseDto, Advertisement> {

    @Override
    @Mapping(target = "advertisementId", source = "advertisementId")
    @Mapping(target = "songId", source = "songId")
    @Mapping(target = "advertisementImage", source = "advertisementImage")
    @Mapping(target = "advertisementContent", source = "advertisementContent")

    AdvertisementResponseDto toDto(Advertisement entity);
}
