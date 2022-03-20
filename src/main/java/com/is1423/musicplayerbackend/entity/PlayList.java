package com.is1423.musicplayerbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "playlist")
@Data
public class PlayList {

    @Id
    @Column(name = "playlist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playlistId;

    @Column(name = "playlist_name")
    private String playlistName;

    @Column(name = "playlist_image")
    private String playlistImage;

    @Column(name = "playlist_icon")
    private String playlistIcon;

    @Column(name = "user_id")
    private Long userId;

    public PlayList(Long userId) {
        this.userId = userId;
    }
}
