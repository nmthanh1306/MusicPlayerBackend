package com.is1423.musicplayerbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeResponseDTO {


    private Long typeId;


    private String themeId;


    private String typeName;


    private String typeImage;
}
