package com.is1423.MusicPlayerBackend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "music_theme")
public class MusicTheme {

    @Id
    @Column(name="theme_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long themeId;

    @Column(name = "theme_name")
    private String themeName;

    @Column(name = "theme_image")
    private String themeImage;
}
