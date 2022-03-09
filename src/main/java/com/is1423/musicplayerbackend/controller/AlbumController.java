package com.is1423.musicplayerbackend.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.AlbumResponseDTO;
import com.is1423.musicplayerbackend.service.AlbumService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/album")
@Slf4j
public class AlbumController {

    private final AlbumService service;

    @GetMapping(value = {"/random", "/random/"})
    public ResponseEntity<List<AlbumResponseDTO>> get4AlbumByDay() {
        log.debug("--- execute method get4AlbumByDay: Start ---");
        List<AlbumResponseDTO> result = service.getAlbumRandom();
        log.debug("--- execute method get4AlbumByDay: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"","/"})
    public ResponseEntity<List<AlbumResponseDTO>> getAll() {
        log.debug("--- execute method get4AlbumByDay: Start ---");
        List<AlbumResponseDTO> result = service.getAll();
        log.debug("--- execute method get4AlbumByDay: End ---");
        return ResponseEntity.ok(result);
    }

}
