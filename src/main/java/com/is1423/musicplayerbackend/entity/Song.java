package com.is1423.musicplayerbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "song")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @Column(name = "song_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long songId;

    @Column(name = "album_id")
    private String albumId;

    @Column(name = "type_id")
    private String typeId;

    @Column(name = "playlist_id")
    private String playlistId;

    @Column(name = "song_image")
    private String songImage;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "singer")
    private String singer;

    @Column(name = "link_song")
    private String linkSong;

    @Column(name = "favourite")
    private int favourite;
}
