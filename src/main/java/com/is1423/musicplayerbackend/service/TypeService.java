package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.TypeResponseDTO;

public interface TypeService {

    List<TypeResponseDTO> getTypeRandom();

    List<TypeResponseDTO> getTypeByThemeId(Long themeId);

    TypeResponseDTO getDetail(Long id);

}
