package com.is1423.musicplayerbackend.model.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlaylistResponseDTO implements Serializable {

    private Long playlistId;

    private String playListName;

    private String playlistImage;

    private String playlistIcon;

    private Long userId;
}
