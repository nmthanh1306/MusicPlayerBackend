package com.is1423.musicplayerbackend.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.MusicThemeResponseDTO;
import com.is1423.musicplayerbackend.service.MusicThemeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/music-theme")
@Slf4j
public class MusicThemeController {

    private final MusicThemeService service;

    @GetMapping(value = {"/random", "/random/"})
    public ResponseEntity<List<MusicThemeResponseDTO>> get4MusicThemeByDay() {
        log.debug("--- execute method get4MusicThemeByDay: Start ---");
        List<MusicThemeResponseDTO> result = service.getMusicThemeRandom();
        log.debug("--- execute method get4MusicThemeByDay: End ---");
        return ResponseEntity.ok(result);
    }


    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<MusicThemeResponseDTO>> getAll() {
        log.debug("--- execute method getAll music theme: Start ---");
        List<MusicThemeResponseDTO> result = service.getAll();
        log.debug("--- execute method getAll music theme: End ---");
        return ResponseEntity.ok(result);
    }


}
