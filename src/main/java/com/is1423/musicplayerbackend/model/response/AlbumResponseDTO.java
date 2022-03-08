package com.is1423.musicplayerbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumResponseDTO {


    private Long albumId;


    private String albumName;


    private String albumSinger;


    private String albumImage;

}
