package com.is1423.MusicPlayerBackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "advertisement")
@Data
public class Advertisement {

    @Id
    @Column(name = "advertisement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertisementId;

    @Column(name = "song_id")
    private String songId;

    @Column(name = "advertisement_image")
    private String advertisementImage;

    @Column(name = "advertisement_content")
    private String advertisementContent;

}
