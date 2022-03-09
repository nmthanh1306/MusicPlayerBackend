package com.is1423.musicplayerbackend.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "type")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
