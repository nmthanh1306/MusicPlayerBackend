package com.is1423.musicplayerbackend.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.PlaylistResponseDTO;
import com.is1423.musicplayerbackend.service.PlaylistService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/playlist")
@Slf4j
public class PlaylistController {

    private final PlaylistService service;

    @GetMapping(value = {"/get3-playlist-random", "/get3-playlist-random/"})
    public ResponseEntity<List<PlaylistResponseDTO>> getAllPlaylists() {
        log.debug("--- execute method getAllPlaylists: Start ---");
        List<PlaylistResponseDTO> result = service.getPlaylistsWasRandom();
        log.debug("--- execute method getAllPlaylists: Start ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<PlaylistResponseDTO>> getAll() {
        log.debug("--- execute method getAll PlayList: Start ---");
        List<PlaylistResponseDTO> result = service.getAll();
        log.debug("--- execute method getAll PlayList: End ---");
        return ResponseEntity.ok(result);
    }
}
