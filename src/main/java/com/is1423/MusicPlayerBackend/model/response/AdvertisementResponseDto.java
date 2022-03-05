package com.is1423.MusicPlayerBackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvertisementResponseDto {

    private Long advertisementId;

    private String songId;

    private String advertisementImage;

    private String advertisementContent;
}
