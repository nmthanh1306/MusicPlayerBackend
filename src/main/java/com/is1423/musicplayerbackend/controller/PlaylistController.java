package com.is1423.musicplayerbackend.controller;

import com.is1423.musicplayerbackend.model.response.PlaylistResponseDTO;
import com.is1423.musicplayerbackend.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/playlist")
public class PlaylistController {

    private final PlaylistService service;

    @GetMapping("/get-all-playlist")
    public ResponseEntity<List<PlaylistResponseDTO>> getAllPlaylists(){
        return ResponseEntity.ok(service.getPlaylistsWasRandom());
    }
}
