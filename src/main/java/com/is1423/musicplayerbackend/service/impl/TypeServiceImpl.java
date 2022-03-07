package com.is1423.musicplayerbackend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.is1423.musicplayerbackend.mapper.TypeMapper;
import com.is1423.musicplayerbackend.model.response.TypeResponseDTO;
import com.is1423.musicplayerbackend.repository.TypeRepository;
import com.is1423.musicplayerbackend.service.TypeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {


    private final TypeRepository repository;
    private final TypeMapper mapper;


    @Override
    public List<TypeResponseDTO> getTypeRandom() {
        return mapper.toDtoList(repository.random4TypePerOneDay());
    }
}
