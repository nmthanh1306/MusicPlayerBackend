package com.is1423.musicplayerbackend.controller;

import java.util.List;
import javax.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;
import com.is1423.musicplayerbackend.service.SongService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/song")
@Slf4j
public class SongController {

    private final SongService service;

    @GetMapping(value = { "/favourite", "/favourite/"})
    public ResponseEntity<List<SongResponseDTO>> getTop5FavoriteSong() {
        log.debug("--- execute method getTop5FavoriteSong: Start ---");
        List<SongResponseDTO> result = service.getListFavouriteSong();
        log.debug("--- execute method getTop5FavoriteSong: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = { "/playlist/{id}", "/playlist/{id}/"})
    public ResponseEntity<List<SongResponseDTO>> getSongByPlayList(@PathVariable @Positive Long id) {
        log.debug("--- execute method getSongByPlayList: Start ---");
        List<SongResponseDTO> result = service.getByPlayListId(id);
        log.debug("--- execute method getSongByPlayList: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = { "/type/{id}", "/type/{id}/"})
    public ResponseEntity<List<SongResponseDTO>> getSongByType(@PathVariable @Positive Long id) {
        log.debug("--- execute method getSongByType: Start ---");
        List<SongResponseDTO> result = service.getByTypeId(id);
        log.debug("--- execute method getSongByType: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = { "/album/{id}", "/album/{id}/"})
    public ResponseEntity<List<SongResponseDTO>> getSongByAlbum(@PathVariable @Positive Long id) {
        log.debug("--- execute method getSongByAlbum: Start ---");
        List<SongResponseDTO> result = service.getByAlbumId(id);
        log.debug("--- execute method getSongByAlbum: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = { "", "/"})
    public ResponseEntity<List<SongResponseDTO>> getSongByNameOrAuthor(@RequestParam(name = "name", required = false) String name) {
        log.debug("--- execute method getSongByNameOrAuthor: Start ---");
        List<SongResponseDTO> result = service.getSongByNameOrAuthor(name);
        log.debug("--- execute method getSongByNameOrAuthor: End ---");
        return ResponseEntity.ok(result);
    }

}
