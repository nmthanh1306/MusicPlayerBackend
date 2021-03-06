package com.is1423.musicplayerbackend.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "album")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
