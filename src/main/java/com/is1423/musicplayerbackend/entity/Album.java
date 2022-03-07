package com.is1423.musicplayerbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    @Column(name = "album_name")
    private String albumName;

    @Column(name = "album_singer")
    private String albumSinger;

    @Column(name = "album_image")
    private String albumImage;

}
