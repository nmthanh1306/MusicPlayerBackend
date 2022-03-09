package com.is1423.musicplayerbackend.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
