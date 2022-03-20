package com.is1423.musicplayerbackend.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<PlaylistResponseDTO>> getAll(@RequestParam(name = "userId", required = false) Long userId) {
        log.debug("--- execute method getAll PlayList: Start ---");
        List<PlaylistResponseDTO> result = service.getAll(userId);
        log.debug("--- execute method getAll PlayList: End ---");
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<PlaylistResponseDTO> create(@RequestBody @Valid PlaylistResponseDTO playlistResponseDTO,
        @RequestParam(name = "userId") Long userId) {
        log.debug("--- execute method create PlayList: Start ---");
        PlaylistResponseDTO result = service.create(playlistResponseDTO, userId);
        log.debug("--- execute method create PlayList: End ---");
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = {"", "/"})
    public ResponseEntity<PlaylistResponseDTO> update(@RequestBody @Valid PlaylistResponseDTO playlistResponseDTO,
        @RequestParam(name = "userId") Long userId) {
        log.debug("--- execute method update PlayList: Start ---");
        PlaylistResponseDTO result = service.update(playlistResponseDTO, userId);
        log.debug("--- execute method update PlayList: End ---");
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Void> delete(@PathVariable @Positive Long id,
        @RequestParam(name = "userId") Long userId) {
        log.debug("--- execute method delete PlayList: Start ---");
        service.delete(id, userId);
        log.debug("--- execute method delete PlayList: End ---");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
