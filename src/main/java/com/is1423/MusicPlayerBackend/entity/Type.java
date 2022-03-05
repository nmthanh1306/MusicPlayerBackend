package com.is1423.MusicPlayerBackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "song_type")
public class Type {

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Column(name = "theme_id")
    private String themeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_image")
    private String typeImage;

}
