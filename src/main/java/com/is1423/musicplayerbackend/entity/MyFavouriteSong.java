package com.is1423.musicplayerbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "my_favourite_song")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFavouriteSong {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "song_id")
    private Long songId;


    public MyFavouriteSong(Long userId, Long songId) {
        this.userId = userId;
        this.songId = songId;
    }
}
