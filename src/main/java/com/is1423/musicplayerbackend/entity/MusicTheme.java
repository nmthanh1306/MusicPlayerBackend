package com.is1423.musicplayerbackend.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "music_theme")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
