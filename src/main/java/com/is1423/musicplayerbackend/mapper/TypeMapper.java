package com.is1423.musicplayerbackend.mapper;

    import org.mapstruct.Mapper;
    import com.is1423.musicplayerbackend.entity.Type;
    import com.is1423.musicplayerbackend.model.response.TypeResponseDTO;

@Mapper(componentModel = "spring")
public interface TypeMapper extends EntityMapper<TypeResponseDTO, Type> {


}
