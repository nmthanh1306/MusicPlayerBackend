package com.is1423.musicplayerbackend.service;

import java.util.List;
import com.is1423.musicplayerbackend.model.response.TypeResponseDTO;

public interface TypeService {

    List<TypeResponseDTO> getTypeRandom();

}
