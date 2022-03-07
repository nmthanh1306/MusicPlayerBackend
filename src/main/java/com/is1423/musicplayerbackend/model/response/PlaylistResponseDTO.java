package com.is1423.musicplayerbackend.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class PlaylistResponseDTO implements Serializable {

    private Long playlistId;

    private String playListName;

    private String playlistImage;

    private String playlistIcon;
}
