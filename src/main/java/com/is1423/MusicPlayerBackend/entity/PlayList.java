package com.is1423.MusicPlayerBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "play_list")
@Data
public class PlayList {

    @Id
    @Column(name = "playlist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistId;

    @Column(name = "play_list_name")
    private String playListName;

    @Column(name = "playlist_image")
    private String playlistImage;

    @Column(name = "playlist_icon")
    private String playlistIcon;

}
