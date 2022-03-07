package com.is1423.musicplayerbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class AdvertisementResponseDTO implements Serializable {

    private Long advertisementId;

    private Long songId;

    private String advertisementImage;

    private String advertisementContent;

    private String songName;

    private String singer;

    private String songImage;

}
