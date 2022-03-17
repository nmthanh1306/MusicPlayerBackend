package com.is1423.musicplayerbackend.model.response;

import lombok.Data;

@Data
public class SongResponseDTO {

    private Long songId;

    private String albumId;

    private String typeId;

    private String playlistId;

    private String songImage;

    private String songName;

    private String singer;

    private String linkSong;

    private int favourite;

    private boolean isUserFavourite = false;
}
